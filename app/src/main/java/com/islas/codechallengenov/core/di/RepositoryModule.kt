package com.islas.codechallengenov.core.di

import com.islas.codechallengenov.data.HomeRepositoryImp
import com.islas.codechallengenov.domain.repository.IHomeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IHomeRepository> { HomeRepositoryImp(get()) }
}