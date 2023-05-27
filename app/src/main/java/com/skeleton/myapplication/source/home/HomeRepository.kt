package com.skeleton.myapplication.source.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.skeleton.myapplication.data.EventResult
import com.skeleton.myapplication.data.network.response.home.HomeResponse
import kotlinx.coroutines.Dispatchers
import org.json.JSONObject

interface HomeRepository{
    fun getPhotos() : LiveData<EventResult<HomeResponse>>
}
class HomeRepositoryImpl(private val dataSource: HomeRemoteDataSource):HomeRepository{
    override fun getPhotos(): LiveData<EventResult<HomeResponse>> =
        liveData(Dispatchers.IO){
            emit(EventResult.Loading)
            try {
                val response = dataSource.getPhotos()
                if (response.isSuccessful){
                    val data = response.body()
                    data?.let {
                        emit(EventResult.Success(it))
                    }
                }
                val error = response.errorBody()?.string()
                if (error != null){
                    val jsonObject = JSONObject(error)
                    val message = jsonObject.getString("message")
                    emit(EventResult.Error(null, message))
                }
            }catch (e:Exception){
                emit(EventResult.Error(null, "Except"))
            }
        }
}