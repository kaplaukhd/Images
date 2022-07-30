package com.kaplaukhd.images.data.repositoroy

import com.kaplaukhd.images.api.ImagesApi
import com.kaplaukhd.images.api.Result
import com.kaplaukhd.images.data.RetrofitServices
import javax.inject.Inject

class ImagesRepository @Inject constructor(private val retrofit: RetrofitServices) :
    BaseRepository() {
    suspend fun getImages(): Result<ArrayList<ImagesApi>> {
        return networkCall {
            retrofit.getImages()
        }
    }
}
