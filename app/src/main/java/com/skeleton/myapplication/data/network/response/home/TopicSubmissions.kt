package com.skeleton.myapplication.data.network.response.home


import com.google.gson.annotations.SerializedName

data class TopicSubmissions(
    @SerializedName("3d-renders")
    val dRenders: DRenders
)