package com.skeleton.myapplication.data.network.response.detail


import com.google.gson.annotations.SerializedName

data class TagsPreview(
    @SerializedName("source")
    val source: SourceXX,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)