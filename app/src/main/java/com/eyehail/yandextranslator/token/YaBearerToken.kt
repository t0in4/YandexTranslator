package com.eyehail.yandextranslator.token

import android.os.AsyncTask
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.URL

class YaBearerToken : AsyncTask<RequestToken?, Void?, ResponseToken?>() {
    fun requestToken(req:RequestToken?): ResponseToken? {
        val gson = Gson()
        val API_URL = "https://iam.api.cloud.yandex.net/iam/v1/tokens"
        val url = URL(API_URL)
        val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
        urlConnection.doOutput = true
        urlConnection.requestMethod = "POST"

        var out: ByteArray = req.toString().toByteArray()
        val stream: OutputStream = urlConnection.outputStream
        stream.write(out)
        try {
            val output = gson.fromJson(
                InputStreamReader(urlConnection.inputStream),
                ResponseToken::class.java
            )
            savedToken = output.iamToken
            return output
        } catch (e:IOException) {
            e.printStackTrace()
            return null
        } finally {
            urlConnection.disconnect()
        }
    }

    override fun doInBackground(vararg params: RequestToken?): ResponseToken? {
        val r = params[0]
        return requestToken(r)
    }
}