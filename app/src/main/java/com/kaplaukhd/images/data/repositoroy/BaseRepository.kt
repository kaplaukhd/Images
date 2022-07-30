package com.kaplaukhd.images.data.repositoroy

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kaplaukhd.images.api.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

abstract class BaseRepository {
   suspend fun <T> networkCall(apiCall: () -> Response<T>): Result<T> =  withContext(Dispatchers.IO) {
            try {
                val response: Response<T> = apiCall()
                if (response.isSuccessful) {
                    Result.Success(data = response.body()!!)
                } else {
                    val  type = object : TypeToken<NetworkException>() {}.type
                    Result.Error(error = (Gson().fromJson(response.errorBody()!!.charStream(), type)
                        ?: "Something went wrong with request"))
                }
            } catch (e: HttpException) {
                Result.Error(error = e.message ?: "Something went wrong")
            } catch (e: IOException) {
                Result.Error("Please check your network connection")
            } catch (e: Exception) {
                Log.d("RequestService", "$e")
                Result.Error(error = " Something went wrong")
            }
        }
    }


class NetworkException{
}
