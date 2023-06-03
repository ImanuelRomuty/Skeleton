package com.skeleton.myapplication.storage

data class UserLoggedIn(
    val accessToken: String,
    val name: String,
    val userId: String
)