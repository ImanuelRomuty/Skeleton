package com.skeleton.myapplication.data.network.response.detail


import com.google.gson.annotations.SerializedName

data class AncestryX(
    @SerializedName("category")
    val category: CategoryX,
    @SerializedName("subcategory")
    val subcategory: SubcategoryX,
    @SerializedName("type")
    val type: TypeX
)