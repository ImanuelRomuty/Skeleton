package com.skeleton.myapplication.data.network.response.detail


import com.google.gson.annotations.SerializedName

data class AncestryXX(
    @SerializedName("category")
    val category: CategoryXX,
    @SerializedName("subcategory")
    val subcategory: SubcategoryXX,
    @SerializedName("type")
    val type: TypeXX
)