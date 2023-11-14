package com.islas.codechallengenov.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Thumbnail(
    val extension: String,
    val path: String
)