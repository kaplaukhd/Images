package com.kaplaukhd.images.api

import com.google.gson.annotations.SerializedName

data class ImagesApi(
    @SerializedName("id") val id: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("color") val color: String,
    @SerializedName("blur_hash") val blur_hash: String,
    @SerializedName("urls") val urls: Urls,
)

data class Urls(
    @SerializedName("raw") val raw: String,
    @SerializedName("full") val full: String,
    @SerializedName("regular") val regular: String,
    @SerializedName("small") val small: String,
    @SerializedName("thumb") val thumb: String,
    @SerializedName("small_s3") val small_s3: String,
)




