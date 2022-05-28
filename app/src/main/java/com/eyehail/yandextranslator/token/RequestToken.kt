package com.eyehail.yandextranslator.token

data class RequestToken(
    val yandexPassportOauthToken: String
) {
    override fun toString(): String {
        return "{\"yandexPassportOauthToken\": \"$yandexPassportOauthToken\"}"
    }
}
