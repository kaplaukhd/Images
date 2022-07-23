package com.kaplaukhd.images.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await
import javax.inject.Inject

class ImagesRepository @Inject constructor(private val retrofit: RetrofitServices) {
    suspend fun getImages() =
        withContext(Dispatchers.IO) {
            retrofit.getImages()
        }
}
