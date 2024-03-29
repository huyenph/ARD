package com.hpcompose.ard.data.datasource.remote.dto.question

import com.google.gson.annotations.SerializedName
import com.hpcompose.ard.core.BaseModel

data class QuestionOwnerResponse(
    @SerializedName("reputation") val reputation: Int = 0,
    @SerializedName("user_id") val userId: String? = null,
    @SerializedName("user_type") val userType: String? = null,
    @SerializedName("profile_image") val profileImage: String? = null,
    @SerializedName("display_name") val displayName: String? = null,
    @SerializedName("link") val link: String? = null,
    @SerializedName("accept_rate") val acceptRate: Int = 0
) : BaseModel()