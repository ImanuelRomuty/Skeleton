package com.skeleton.myapplication.data.network.response.detail


import com.google.gson.annotations.SerializedName

data class RelatedCollections(
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("type")
    val type: String
)