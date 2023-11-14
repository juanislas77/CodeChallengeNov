package com.islas.codechallengenov.data.utils

sealed class ResultApi<out T>{
    data class Success<T>(val data: T): ResultApi<T>()
    data object Error: ResultApi<Nothing>()
}
