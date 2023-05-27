package com.skeleton.myapplication.data.network.response.detail


import com.google.gson.annotations.SerializedName

data class Exif(
    @SerializedName("aperture")
    val aperture: Any,
    @SerializedName("exposure_time")
    val exposureTime: Any,
    @SerializedName("focal_length")
    val focalLength: String,
    @SerializedName("iso")
    val iso: Any,
    @SerializedName("make")
    val make: Any,
    @SerializedName("model")
    val model: Any,
    @SerializedName("name")
    val name: Any
)