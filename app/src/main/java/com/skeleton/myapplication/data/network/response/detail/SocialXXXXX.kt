package com.skeleton.myapplication.data.network.response.detail


import com.google.gson.annotations.SerializedName

data class SocialXXXXX(
    @SerializedName("instagram_username")
    val instagramUsername: String,
    @SerializedName("paypal_email")
    val paypalEmail: Any,
    @SerializedName("portfolio_url")
    val portfolioUrl: String,
    @SerializedName("twitter_username")
    val twitterUsername: Any
)