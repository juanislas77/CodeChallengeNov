package com.islas.codechallengenov.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Mappers(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: Data,
    val etag: String,
    val status: String
)