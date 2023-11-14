package com.islas.codechallengenov.data.utils

import com.islas.codechallengenov.data.models.CharacterResult
import com.islas.codechallengenov.domain.models.Character

fun CharacterResult.toDomain() = Character(
    id = this.id.toString(),
    name = this.name,
    description = this.description,
    image = this.thumbnail.path
)