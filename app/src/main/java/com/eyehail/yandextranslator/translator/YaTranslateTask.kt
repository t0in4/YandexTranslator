package com.eyehail.yandextranslator.translator

import android.os.AsyncTask
import android.util.Log
import com.eyehail.yandextranslator.token.savedToken
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.URL

class YaTranslateTask : AsyncTask<Request?, Void?, Response?>() {
    fun requestToServer(req: Request?): Response? {
        val gson = Gson()
        val API_URL = "https://translate.api.cloud.yandex.net/translate/v2/translate"
        val url = URL(API_URL)
        val IAM_TOKEN = "Bearer $savedToken"
        val contentType = "application/json"
        val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
        urlConnection.doOutput = true
        urlConnection.requestMethod= "POST"
        urlConnection.setRequestProperty("Authorization", IAM_TOKEN)
        urlConnection.setRequestProperty("Content-Type", contentType)
        val out: ByteArray = req.toString().toByteArray()
        val stream: OutputStream = urlConnection.getOutputStream()
        stream.write(out)
        try {
            val output = gson.fromJson(
                InputStreamReader(urlConnection.inputStream),
                Response::class.java
            )

            Log.i("Result", "$output")
            return output
        } catch(e: IOException) {
            e.printStackTrace()
            return null
        } finally {
            urlConnection.disconnect()
        }
    }

    override fun doInBackground(vararg params: Request?): Response? {
        val r = params[0]
        return requestToServer(r)
    }
}