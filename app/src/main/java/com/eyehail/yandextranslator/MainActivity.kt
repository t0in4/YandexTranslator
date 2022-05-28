package com.eyehail.yandextranslator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eyehail.yandextranslator.token.RequestToken
import com.eyehail.yandextranslator.token.YaBearerToken
import com.eyehail.yandextranslator.translator.Request
import com.eyehail.yandextranslator.translator.YaTranslateTask


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // you have to create file in root to hold the OauthToken and folderId token
        val requestToken = RequestToken(secret.yandexPassportOauthToken)
        val token = YaBearerToken()
        token.execute(requestToken)
        val req = Request(listOf("Lovely", "Mariana"), "ru", secret.folderId)
        val task = YaTranslateTask()
        task.execute(req)
    }
}
