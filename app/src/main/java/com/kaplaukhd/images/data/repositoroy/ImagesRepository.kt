package com.kaplaukhd.images.data.repositoroy

import androidx.paging.DataSource
import com.kaplaukhd.images.model.ImagesApi
import com.kaplaukhd.images.model.Result
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
