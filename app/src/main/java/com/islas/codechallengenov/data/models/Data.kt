package com.islas.codechallengenov.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<CharacterResult>,
    val total: Int
)