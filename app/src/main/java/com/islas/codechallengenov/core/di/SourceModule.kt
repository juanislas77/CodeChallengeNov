package com.islas.codechallengenov.core.di

import com.islas.codechallengenov.data.CharacterPagingSource
import org.koin.dsl.module

val sourceModule = module {
    single { CharacterPagingSource(get()) }
}