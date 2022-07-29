package com.kaplaukhd.images.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

abstract class BaseRepository() {
    suspend fun <T> apiCall(apiToBeCalled: () -> Response<T>): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<T> = apiToBeCalled()
                if (response.isSuccessful) {
                    Resource.Success(data = response.body()!!)
                } else {
                    val errorResponse = response.errorBody()
                    Resource.Error(error = errorResponse?.source().toString()
                        ?: "Something went wrong")
                }
            } catch (e: HttpException) {
                Resource.Error(error = e.message ?: "Something went wrong")
            } catch (e: IOException) {
                Resource.Error("Please check your network connection")
            } catch (e: Exception) {
                Resource.Error(error = "Something went wrong")
            }
        }
    }
}
