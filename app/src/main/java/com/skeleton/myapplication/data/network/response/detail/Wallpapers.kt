package com.skeleton.myapplication.data.network.response.detail


import com.google.gson.annotations.SerializedName

data class Wallpapers(
    @SerializedName("approved_on")
    val approvedOn: String,
    @SerializedName("status")
    val status: String
)