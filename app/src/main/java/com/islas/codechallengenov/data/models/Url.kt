package com.islas.codechallengenov.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Url(
    val type: String,
    val url: String
)