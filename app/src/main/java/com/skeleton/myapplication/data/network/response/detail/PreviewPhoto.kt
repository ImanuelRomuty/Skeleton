package com.skeleton.myapplication.data.network.response.detail


import com.google.gson.annotations.SerializedName

data class PreviewPhoto(
    @SerializedName("blur_hash")
    val blurHash: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("urls")
    val urls: UrlsX
)