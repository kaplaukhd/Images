package com.kaplaukhd.images.data

import com.kaplaukhd.images.BuildConfig
import com.kaplaukhd.images.model.ImagesApi
import com.kaplaukhd.images.data.Utils.ACCESS_KEY
import com.kaplaukhd.images.data.Utils.ORDER_BY
import com.kaplaukhd.images.data.Utils.PER_PAGE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {
    @GET("photos")
    suspend fun getImages(
        @Query("client_id") clientId: String = ACCESS_KEY,
        @Query("per_page") perPage: Int = PER_PAGE,
        @Query("order_by") orderBy: String = ORDER_BY,
    ): Response<ArrayList<ImagesApi>>
}

object Utils {
    const val ACCESS_KEY = BuildConfig.APIKEY
    const val PER_PAGE = 100
    const val ORDER_BY = "popular"
}