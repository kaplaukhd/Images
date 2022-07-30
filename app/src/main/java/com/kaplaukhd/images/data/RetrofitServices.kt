package com.kaplaukhd.images.data

import com.kaplaukhd.images.BuildConfig
import com.kaplaukhd.images.api.ImagesApi
import com.kaplaukhd.images.data.Utils.ACCESS_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {
    @GET("photos")
    suspend fun getImages(@Query("client_id") clientId: String = ACCESS_KEY): Response<ArrayList<ImagesApi>>
}

object Utils{
    const val ACCESS_KEY = BuildConfig.APIKEY
}