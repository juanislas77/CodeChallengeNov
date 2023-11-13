package com.islas.codechallengenov.domain

import com.islas.codechallengenov.data.mappers.Data
import com.islas.codechallengenov.data.mappers.Mappers
import com.islas.codechallengenov.domain.repository.IMarvelApi
import com.islas.codechallengenov.domain.utils.ClientHttp
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

private val json = Json {
    isLenient = true
    ignoreUnknownKeys = true
}

class IMarvelApiImpl : IMarvelApi {
    @OptIn(DelicateCoroutinesApi::class)
    override fun makeCall() {
        GlobalScope.launch(Dispatchers.IO) {
            val apiString =
                ClientHttp.BASE_URL + "/v1/public/characters?limit=50&ts=" + ClientHttp.timeStamp + "&apikey=" + ClientHttp.API_KEY + "&hash=" + ClientHttp.hash()
            println(apiString)
            try {
                val result = fetchData(apiString)

                println("The call was done")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    override fun fetchData(apiUrl: String) {
        println("Attempting to fetch JSON")
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(apiUrl)
            .build()
        val somethingExp = client.newCall(request).enqueue(object : Callback{
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                val marvelCharacters = body?.let { json.decodeFromString<Mappers>(it) }
                println(marvelCharacters)
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Fetch failed")
            }
        })

//    override fun fetchData(apiUrl: String): Response {
//        val client = OkHttpClient()
//        val request = Request.Builder()
//            .url(apiUrl)
//            .build()
//        val somethingExp = client.newCall(request).execute().use { response ->
//            if (!response.isSuccessful) throw IOException("Unexpected code $response")
//
//            else{
//                val body = response.body
//                val list = body?.let { json.decodeFromString<Mappers>(it.string()) }
//            }
//        }
//        somethingExp.toString()
//        return client.newCall(request).execute()
    }
}


//fun otherMakeCall() {
//    val apiString =
//        ClientHttp.BASE_URL + "/v1/public/characters?limit=10&ts=" + ClientHttp.timeStamp + "&apikey=" + ClientHttp.API_KEY + "&hash=" + ClientHttp.hash()
//    println(apiString)
//    try {
//        val result = otherFetchData(apiString)
//        result.length
//        println("The call was done")
//    } catch (e: Exception) {
//        e.printStackTrace()
//    }
//
//}
//
//fun otherFetchData(apiUrl: String): String {
//    val client = OkHttpClient()
//    var body = ""
//    val request = Request.Builder()
//        .url(apiUrl)
//        .build()
//    client.newCall(request).enqueue(object : Callback {
//        override fun onFailure(call: Call, e: IOException) {
//            e.printStackTrace()
//        }
//
//        override fun onResponse(call: Call, response: Response) {
//            Log.i("Response", "Received Response from server")
//            response.use {
//                if (!response.isSuccessful){
//                    Log.e("HTTP Error", "Something didn't load")
//                }
//                else{
//                    body = response.body?.toString() ?: "No Body"
//                    val bodyDone = body.toString()
//                }
//            }
//        }
//    })
//    return body
//}