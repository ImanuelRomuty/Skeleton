package com.skeleton.myapplication.data.network.response.detail


import com.google.gson.annotations.SerializedName

data class TagX(
    @SerializedName("source")
    val source: SourceX,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)