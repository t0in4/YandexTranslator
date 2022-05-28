package com.eyehail.yandextranslator.token

data class SavedToken(var token: String) {
    override fun toString(): String {
        return "$token"
    }
}

var savedToken = SavedToken(" ").toString()
