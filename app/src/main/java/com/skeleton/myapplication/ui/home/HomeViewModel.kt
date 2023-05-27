package com.skeleton.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.skeleton.myapplication.data.EventResult
import com.skeleton.myapplication.data.network.response.home.HomeResponse
import com.skeleton.myapplication.source.home.HomeRepository

class HomeViewModel(
    private val repository: HomeRepository
) :ViewModel(){
    fun getPhotos():LiveData<EventResult<HomeResponse>> = repository.getPhotos()
}