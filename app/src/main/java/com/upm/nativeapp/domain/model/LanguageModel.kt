package com.upm.nativeapp.domain.model

data class LanguageModel(
    val language: String,
    val description: String,
    val locale: String,
) : BaseModel()