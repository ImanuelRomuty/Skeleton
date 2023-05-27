package com.skeleton.myapplication.data.network.response.detail


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("city")
    val city: Any,
    @SerializedName("country")
    val country: Any,
    @SerializedName("name")
    val name: String,
    @SerializedName("position")
    val position: Position
)