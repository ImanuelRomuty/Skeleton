package com.skeleton.myapplication.data.network.response.detail


import com.google.gson.annotations.SerializedName

data class TopicSubmissionsX(
    @SerializedName("architecture-interior")
    val architectureInterior: ArchitectureInterior,
    @SerializedName("color-of-water")
    val colorOfWater: ColorOfWater,
    @SerializedName("nature")
    val nature: Nature,
    @SerializedName("textures-patterns")
    val texturesPatterns: TexturesPatterns,
    @SerializedName("wallpapers")
    val wallpapers: Wallpapers
)