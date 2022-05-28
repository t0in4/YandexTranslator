package com.eyehail.yandextranslator.translator

data class Response(
    val translations: List<Translation>
)

data class Translation(
    val detectedLanguageCode: String,
    val text: String
)
