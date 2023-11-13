package com.islas.codechallengenov.domain.repository

import com.islas.codechallengenov.data.mappers.Mappers

interface IMarvelApi {
    fun makeCall()
    fun fetchData(apiUrl: String)
}