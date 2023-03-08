package com.hpcompose.ard.di

import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hpcompose.ard.BuildConfig
import com.hpcompose.ard.data.local.storage.Storage
import com.hpcompose.ard.data.remote.ApiService
import com.hpcompose.ard.data.remote.adapter.NetworkResponseAdapterFactory
import com.hpcompose.ard.data.remote.helper.HttpError
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import okio.Buffer
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.X509TrustManager

const val CONNECT_TIMEOUT = 1L
const val READ_TIMEOUT = 1L
const val WRITE_TIMEOUT = 1L

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class GsonBuilderLenient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UnAuthInterceptorOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthInterceptorOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UnAuthNetworkService

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthNetworkService

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @GsonBuilderLenient
    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    fun interceptor(): Interceptor = Interceptor { chain ->
        var request = chain.request()
        var response = chain.proceed(request)
        if (response.code == 401) {
            response.close()
            // refreshToken here
            //....
            if (request.method == "GET") {
                val requestUrl = request.url.newBuilder().build()
                request = request
                    .newBuilder()
                    .url(requestUrl)
                    .removeHeader("Authorization")
                    .addHeader("Authorization", "")
                    .build()
            } else if (request.method == "POST") {
                val buffer = Buffer()
                request.body?.let {
                    it.writeTo(buffer)
                    val jsonBody = buffer.readUtf8()
                    val jsonObject = JSONObject(jsonBody)
                        .put("accessToken", "")
                    request = request
                        .newBuilder()
                        .post(jsonObject.toString().toRequestBody(it.contentType()))
                        .build()
                }
            }
            response = chain.proceed(request)
        }
        if (response.code >= 400) {
            throw Exception(HttpError.getErrorString(response))
        }
        val root = response.peekBody(Long.MAX_VALUE).string()
        val resultObject = JSONObject()

        if (TextUtils.equals(root, "[]")) {
            /**
             * Generate a success response.
             * HTTP/1.1 200 OK
             * Content-type: application/json
             * "$random_string"
             */
            resultObject.put("message", "unknown result")
            response = response.newBuilder()
                .code(200)
                .protocol(Protocol.HTTP_1_1)
                .message("OK")
                .body(resultObject.toString().toResponseBody(response.body!!.contentType()))
                .build()
        }
        try {
            val jsonObject = JSONObject(root)
            if (jsonObject.has("error")) {
                /**
                 * Generate an error result.
                 * HTTP/1.1 500 Bad server day
                 * Content-type: application/json
                 * {"message": "unknown error"}
                 */
                resultObject.put("message", "unknown error")
                response = response.newBuilder()
                    .code(500)
                    .protocol(Protocol.HTTP_1_1)
                    .message("ERROR")
                    .body(resultObject.toString().toResponseBody(response.body!!.contentType()))
                    .build()
            }
        } catch (e: JSONException) {
            throw IOException(e.message)
        }
        response
    }

    @UnAuthInterceptorOkHttpClient
    @Provides
    @Singleton
    fun provideUnAuthInterceptorOkHttpClient(
        interceptor: Interceptor,
        sslSocketFactory: SSLSocketFactory,
        trustManager: X509TrustManager,
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MINUTES)
            .readTimeout(READ_TIMEOUT, TimeUnit.MINUTES)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.MINUTES)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(interceptor)
            .addInterceptor { chain ->
                val request: Request = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "*/*")
                    .build()
                chain.proceed(request)
            }
        if (BuildConfig.NEED_SSL) {
            builder.sslSocketFactory(sslSocketFactory, trustManager)
        }
        return builder.build()
    }

    @AuthInterceptorOkHttpClient
    @Provides
    @Singleton
    fun provideAuthInterceptorOkHttpClient(
        interceptor: Interceptor,
        sslSocketFactory: SSLSocketFactory,
        trustManager: X509TrustManager,
        storage: Storage
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MINUTES)
            .readTimeout(READ_TIMEOUT, TimeUnit.MINUTES)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.MINUTES)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(interceptor)
            .addInterceptor { chain ->
                val request: Request = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "*/*")
                    .addHeader("Authorization", "Bearer ${storage.getString("token")}")
                    .build()
                chain.proceed(request)
            }
        if (BuildConfig.NEED_SSL) {
            builder.sslSocketFactory(sslSocketFactory, trustManager)
        }
        return builder.build()
    }

    @UnAuthNetworkService
    @Provides
    fun provideUnAuthNetworkService(
        @UnAuthInterceptorOkHttpClient okHttpClient: OkHttpClient,
        @GsonBuilderLenient gson: Gson
    ): ApiService =
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)

    @AuthNetworkService
    @Provides
    fun provideAuthNetworkService(
        @AuthInterceptorOkHttpClient okHttpClient: OkHttpClient,
        @GsonBuilderLenient gson: Gson
    ): ApiService = Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(NetworkResponseAdapterFactory())
//        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()
        .create(ApiService::class.java)
}