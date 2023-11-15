package com.islas.codechallengenov.data

import com.islas.codechallengenov.data.models.Data
import com.islas.codechallengenov.data.models.Mappers
import com.islas.codechallengenov.data.utils.ClientHttp
import com.islas.codechallengenov.domain.repository.IHomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request

private val json = Json {
    isLenient = true
    ignoreUnknownKeys = true
}

class HomeRepositoryImp(private val okHttpClient: OkHttpClient) : IHomeRepository {
    override suspend fun makeCall(pageNumber: Int): Data {
        return withContext(Dispatchers.IO) {
            val apiUrl =
                "${ClientHttp.BASE_URL}/v1/public/characters?offset=$pageNumber&limit=${ClientHttp.LIMIT}&ts=${ClientHttp.timeStamp}&apikey=${ClientHttp.API_KEY}&hash=${ClientHttp.hash()}"
            val request = Request.Builder().url(apiUrl).build()


            val response = async {
                okHttpClient.newCall(request).execute()
            }.await()

            val body = response.body?.string()
            val result = body?.let { json.decodeFromString<Mappers>(it) }
            return@withContext result?.data ?: throw IllegalStateException("Invalid response body")
        }
    }
}