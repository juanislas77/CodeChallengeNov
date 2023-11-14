package com.islas.codechallengenov.domain.repository

import com.islas.codechallengenov.data.models.Data
import com.islas.codechallengenov.data.models.Mappers

interface IHomeRepository {
    suspend fun makeCall(pageNumber: Int): Data
    suspend fun fetchData(apiUrl: String): Mappers
}