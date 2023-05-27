package com.skeleton.myapplication.source

import com.skeleton.myapplication.data.network.service.ApiService

class MainRemoteDataSource constructor(private val apiService: ApiService){
    suspend fun getPhotos() = apiService.getPhotos()
    suspend fun getDetail(id:String) = apiService.getDetail(id)
}