package com.kaplaukhd.images.data

sealed class Result<T>(
    val data: T? = null,
    val message: String? = null,
) {
    class Success<T>(data: T): Result<T>(data = data)
    class Error<T>(error: String): Result<T>(message = error)
}
