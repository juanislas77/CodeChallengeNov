package com.islas.codechallengenov.data

import com.islas.codechallengenov.data.models.Mappers
import com.islas.codechallengenov.domain.repository.IHomeRepository
import com.islas.codechallengenov.data.utils.ClientHttp
import com.islas.codechallengenov.data.utils.ResultApi
import com.islas.codechallengenov.data.utils.toDomain
import com.islas.codechallengenov.domain.models.Character
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

class HomeRepositoryImp : IHomeRepository {
    @OptIn(DelicateCoroutinesApi::class)
    override fun makeCall(resultApi: (ResultApi<List<Character>>) -> Unit) {
        GlobalScope.launch(Dispatchers.IO) {
            val apiString =
                ClientHttp.BASE_URL + "/v1/public/characters?limit=50&ts=" + ClientHttp.timeStamp + "&apikey=" + ClientHttp.API_KEY + "&hash=" + ClientHttp.hash()
            println(apiString)
            try {
                fetchData(apiString){ dataDTO ->
                    val characterList = dataDTO.data.results.map { characterResult ->
                        characterResult.toDomain()
                    }
                    resultApi(ResultApi.Success(characterList))
                }
                println("The call was done")
            } catch (e: Exception) {
                e.printStackTrace()
                resultApi(ResultApi.Error)
            }
        }
    }

    override fun fetchData(apiUrl: String, apiResponse: (Mappers) -> Unit) {
        println("Attempting to fetch JSON")
        val client = OkHttpClient()
        val request = Request.Builder().url(apiUrl).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                body?.let { apiResponse(json.decodeFromString<Mappers>(it)) }
//                println("We must provide this object to the list fragment to fill the recycler view $marvelCharacters")
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Fetch failed")
            }
        })

    }
}