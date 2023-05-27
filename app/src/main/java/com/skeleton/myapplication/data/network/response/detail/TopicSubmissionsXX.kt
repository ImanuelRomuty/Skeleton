package com.skeleton.myapplication.data.network.response.detail


import com.google.gson.annotations.SerializedName

data class TopicSubmissionsXX(
    @SerializedName("architecture-interior")
    val architectureInterior: ArchitectureInteriorX,
    @SerializedName("color-of-water")
    val colorOfWater: ColorOfWaterX,
    @SerializedName("nature")
    val nature: NatureX,
    @SerializedName("wallpapers")
    val wallpapers: WallpapersX
)