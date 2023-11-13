package com.islas.codechallengenov.data.mappers

import kotlinx.serialization.Serializable

@Serializable
data class Thumbnail(
    val extension: String,
    val path: String
)