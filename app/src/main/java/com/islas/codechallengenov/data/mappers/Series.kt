package com.islas.codechallengenov.data.mappers

import kotlinx.serialization.Serializable

@Serializable
data class Series(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)