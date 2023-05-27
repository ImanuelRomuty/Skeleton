package com.example.storyappbiasa.storage

data class UserLoggedIn(
    val accessToken: String,
    val name: String,
    val userId: String
)