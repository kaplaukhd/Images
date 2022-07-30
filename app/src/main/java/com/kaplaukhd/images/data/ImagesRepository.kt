package com.kaplaukhd.images.data

import com.kaplaukhd.images.api.ImagesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class ImagesRepository @Inject constructor(private val retrofit: RetrofitServices) :
    BaseRepository() {

    suspend fun getImages() = networkCall {
            retrofit.getImages()
    }
}
