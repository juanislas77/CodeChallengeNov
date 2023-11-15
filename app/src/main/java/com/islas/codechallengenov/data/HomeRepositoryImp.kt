package com.islas.codechallengenov.data

import com.islas.codechallengenov.data.models.Data
import com.islas.codechallengenov.data.models.Mappers
import com.islas.codechallengenov.data.utils.ClientHttp
import com.islas.codechallengenov.domain.repository.IHomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

private val json = Json {
    isLenient = true
    ignoreUnknownKeys = true
}

class HomeRepositoryImp : IHomeRepository {
    override suspend fun makeCall(pageNumber: Int): Data {
        return withContext(Dispatchers.IO) {
            val apiUrl =
                "${ClientHttp.BASE_URL}/v1/public/characters?offset=$pageNumber&limit=${ClientHttp.LIMIT}&ts=${ClientHttp.timeStamp}&apikey=${ClientHttp.API_KEY}&hash=${ClientHttp.hash()}"
            val client = OkHttpClient()
            val request = Request.Builder().url(apiUrl).build()

            suspendCoroutine { continuation ->
                client.newCall(request).enqueue(object : Callback {
                    override fun onResponse(call: Call, response: Response) {
                        val body = response.body?.string()
                        val result = body?.let { json.decodeFromString<Mappers>(it) }
                        continuation.resume(
                            result?.data ?: throw IllegalStateException("Invalid response body")
                        )
                    }

                    override fun onFailure(call: Call, e: IOException) {
                        continuation.resumeWithException(e)
                    }
                })
            }
        }
    }

}