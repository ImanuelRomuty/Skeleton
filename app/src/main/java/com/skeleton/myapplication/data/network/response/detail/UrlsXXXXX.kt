package com.skeleton.myapplication.data.network.response.detail


import com.google.gson.annotations.SerializedName

data class UrlsXXXXX(
    @SerializedName("full")
    val full: String,
    @SerializedName("raw")
    val raw: String,
    @SerializedName("regular")
    val regular: String,
    @SerializedName("small")
    val small: String,
    @SerializedName("small_s3")
    val smallS3: String,
    @SerializedName("thumb")
    val thumb: String
)