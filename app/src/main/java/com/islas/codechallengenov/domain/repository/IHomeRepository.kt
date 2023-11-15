package com.islas.codechallengenov.domain.repository

import com.islas.codechallengenov.data.models.Data

interface IHomeRepository {
    suspend fun makeCall(pageNumber: Int): Data
}