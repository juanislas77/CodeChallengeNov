package com.islas.codechallengenov.domain.repository

import com.islas.codechallengenov.data.models.Mappers
import com.islas.codechallengenov.data.utils.ResultApi
import com.islas.codechallengenov.domain.models.Character

interface IHomeRepository {
    fun makeCall(resultApi: (ResultApi<List<Character>>) -> Unit)
    fun fetchData(apiUrl: String, apiResponse: (Mappers) -> Unit)
}