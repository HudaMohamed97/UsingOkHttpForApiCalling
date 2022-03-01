package com.example.assignment.presenter

import com.example.assignment.views.MainView
import com.example.assignment.data.ResultsData
import com.example.assignment.network.OkHttpRequest
import com.example.assignment.utils.ApiHelperUtil.ACCESS_TOKEN
import com.example.assignment.utils.ApiHelperUtil.GATEWAY_KEY
import com.example.assignment.utils.ApiHelperUtil.GATEWAY_VALUE
import com.example.assignment.utils.ApiHelperUtil.HOST_URL
import com.example.assignment.utils.ApiHelperUtil.POST_URL
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import org.json.JSONObject
import java.io.IOException


class MainPresenter(private var view: MainView) : PresenterInterface {
    var client: OkHttpClient = OkHttpClient()
    var request: OkHttpRequest = OkHttpRequest(client)

    override fun getAccessToken(searchText: String) {
        val map: HashMap<String, String> =
            hashMapOf(GATEWAY_KEY to GATEWAY_VALUE)
        request.POST(POST_URL,
            map,
            object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    println("Request Failure.")
                }

                override fun onResponse(call: Call, response: Response) {
                    val responseData = response.body?.string()
                    val json = JSONObject(responseData)
                    val accessToken = json.getString(ACCESS_TOKEN)
                    callList(accessToken, searchText)
                }
            })
    }

    private fun callList(accessToken: String, searchText: String) {
        val httpUrl: HttpUrl = HttpUrl.Builder()
            .scheme("http")
            .host(HOST_URL)
            .addPathSegment("v2")
            .addPathSegment("api")
            .addPathSegment("sayt")
            .addPathSegment("flat")
            .addQueryParameter(
                "query",
                searchText
            )
            .build()
        request.getApi(httpUrl, accessToken, object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Request Failure.")
            }

            override fun onResponse(call: Call, response: Response) {
                val responseData = response.body?.string()
                val gson = Gson()
                val arrayTutorialType = object : TypeToken<Array<ResultsData>>() {}.type
                var result: Array<ResultsData> = gson.fromJson(responseData, arrayTutorialType)
                view.setResultArrayList(result)
            }
        })
    }
}