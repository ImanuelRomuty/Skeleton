package com.skeleton.myapplication.data.network.response.detail


import com.google.gson.annotations.SerializedName

data class SocialXX(
    @SerializedName("instagram_username")
    val instagramUsername: Any,
    @SerializedName("paypal_email")
    val paypalEmail: Any,
    @SerializedName("portfolio_url")
    val portfolioUrl: Any,
    @SerializedName("twitter_username")
    val twitterUsername: Any
)