package com.islas.codechallengenov.data.mappers

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Result>,
    val total: Int
)