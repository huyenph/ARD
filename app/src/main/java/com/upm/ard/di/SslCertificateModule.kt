package com.upm.ard.di

import android.content.Context
import androidx.annotation.RawRes
import com.upm.ard.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.tls.HandshakeCertificates
import okhttp3.tls.decodeCertificatePem
import java.security.cert.X509Certificate
import javax.inject.Singleton
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.X509TrustManager

@Module
@InstallIn(SingletonComponent::class)
object SslCertificateModule {
    @Provides
    @Singleton
    fun provideCertificate(@ApplicationContext context: Context): HandshakeCertificates {
        val builder = HandshakeCertificates.Builder()
        listOf(
            R.raw.cert1,
            R.raw.cert2,
        ).forEach {
            getCertificate(context, it)?.let { cer -> builder.addTrustedCertificate(cer) }
        }
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideSslSocketFactory(certificates: HandshakeCertificates): SSLSocketFactory =
        certificates.sslSocketFactory()

    @Provides
    @Singleton
    fun provideTrustManager(certificates: HandshakeCertificates): X509TrustManager =
        certificates.trustManager

    private fun getCertificate(context: Context, @RawRes resId: Int): X509Certificate? {
        return try {
            context.resources.openRawResource(resId)
                .bufferedReader()
                .use { it.readText() }
                .trimIndent()
                .decodeCertificatePem()
        } catch (e: Exception) {
            null
        }
    }
}