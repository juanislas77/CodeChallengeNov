package com.islas.codechallengenov.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val name: String,
    val resourceURI: String
)