package com.kaplaukhd.images.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kaplaukhd.images.api.ImagesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.chromium.net.NetworkException
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

abstract class BaseRepository() {
   suspend fun <T> networkCall(apiCall: () -> Response<T>): Result<T> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<T> = apiCall()
                if (response.isSuccessful) {
                    Result.Success(data = response.body()!!)
                } else {
                    val  type = object : TypeToken<NetworkException>() {}.type
                    Result.Error(error = (Gson().fromJson(response.errorBody()!!.charStream(), type)
                        ?: "Something went wrong"))
                }
            } catch (e: HttpException) {
                Result.Error(error = e.message ?: "Something went wrong")
            } catch (e: IOException) {
                Result.Error("Please check your network connection")
            } catch (e: Exception) {
                Result.Error(error = "Something went wrong")
            }
        }
    }
}
