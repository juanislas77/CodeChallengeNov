package com.islas.codechallengenov.data

import kotlinx.serialization.Serializable

@Serializable
data class AnswerFromAPI(
    val code: Int,
    val status: String,
    val copyright: String,
    val data: Data,
)

@Serializable
data class Data(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val result: ResponseCharacterDTO
)

@Serializable
data class ResponseCharacterDTO(
    val results: List<CharacterDTO>
)

@Serializable
data class CharacterDTO(
    val id: String,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail,
    val resourceURI: String
)

@Serializable
data class Thumbnail(
    val path: String,
    val extension: String
)