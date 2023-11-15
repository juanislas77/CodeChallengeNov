package com.islas.codechallengenov.core.di

import okhttp3.OkHttpClient
import org.koin.dsl.module

val networkModule = module {
    single { provideOkHttpClient() }
}

fun provideOkHttpClient(): OkHttpClient =  OkHttpClient()