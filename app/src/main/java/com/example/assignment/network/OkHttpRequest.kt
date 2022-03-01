package com.example.assignment.network

import com.example.assignment.utils.ApiHelperUtil.AUTHENTICATION
import com.example.assignment.utils.ApiHelperUtil.GATEWAY_KEY
import com.example.assignment.utils.ApiHelperUtil.GATEWAY_VALUE
import okhttp3.*
import java.util.*
import java.util.Map

class OkHttpRequest(client: OkHttpClient) {
    private var client = OkHttpClient()
    init {
        this.client = client
    }

    fun POST(url: String, parameters: HashMap<String, String>, callback: Callback): Call {
        val builder = FormBody.Builder()
        val it = parameters.entries.iterator()
        while (it.hasNext()) {
            val pair = it.next() as Map.Entry<*, *>
            builder.add(pair.key.toString(), pair.value.toString())
        }
        val formBody = builder.build()
        val request = Request.Builder()
            .url(url)
            .post(formBody)
            .addHeader(GATEWAY_KEY, GATEWAY_VALUE)
            .build()
        val call = client.newCall(request)
        call.enqueue(callback)
        return call
    }

    fun getApi(url: HttpUrl, header: String, callback: Callback): Call {
        val request = Request.Builder()
            .url(url)
            .addHeader(AUTHENTICATION, "Bearer $header")
            .build()

        val call = client.newCall(request)
        call.enqueue(callback)
        return call
    }
}