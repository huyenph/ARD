package com.upm.nativeapp.domain.model

enum class AppConfigType { LANGUAGE, THEME }

data class AppConfigModel(var language: LanguageModel, var configType: AppConfigType) : BaseModel()

data class LanguageModel(
    val language: String,
    val description: String,
    val locale: String,
) : BaseModel()