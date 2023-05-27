package com.skeleton.myapplication.source.home

import com.skeleton.myapplication.data.network.service.ApiService

class HomeRemoteDataSource constructor(private val apiService: ApiService){
    suspend fun getPhotos() = apiService.getPhotos()
}