package com.skeleton.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.skeleton.myapplication.data.EventResult
import com.skeleton.myapplication.data.network.response.detail.DetailResponse
import com.skeleton.myapplication.data.network.response.home.HomeResponse
import com.skeleton.myapplication.data.network.response.search.SearchResponse
import com.skeleton.myapplication.source.MainRepository

class MainViewModel(
    private val repository: MainRepository
) :ViewModel(){
    fun getPhotos():LiveData<EventResult<HomeResponse>> = repository.getPhotos()
    fun getDetail(id:String):LiveData<EventResult<DetailResponse>> = repository.getDetailPhotos(id)
    fun getSearch(query:String):LiveData<EventResult<SearchResponse>> = repository.getSearch(query)
}