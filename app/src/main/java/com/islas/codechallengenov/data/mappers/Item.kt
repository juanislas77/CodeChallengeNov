package com.islas.codechallengenov.data.mappers

import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val name: String,
    val resourceURI: String
)