package com.eyehail.yandextranslator.translator

data class Request(
    val texts: List<String>,
    val targetLanguageCode: String,
    val folderId: String
) {
    override fun toString(): String {
        return "{\"texts\": \"$texts\", \"targetLanguageCode\": \"$targetLanguageCode\"," +
                "\"folderId\": \"$folderId\"}"
    }
}
