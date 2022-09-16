package com.upm.ard.domain.model

enum class AppConfigType { DEFAULT, LANGUAGE, THEME }

enum class AppThemingType { LIGHT, DARK }

data class AppConfigModel(
    var language: LanguageModel = LanguageModel(),
    var appThemingType: AppThemingType = AppThemingType.LIGHT,
    var configType: AppConfigType = AppConfigType.DEFAULT
) : BaseModel()

data class LanguageModel(
    val language: String = "English",
    val description: String = "English",
    val locale: String = "en",
) : BaseModel()