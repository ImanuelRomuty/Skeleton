package com.skeleton.myapplication.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.skeleton.myapplication.data.EventResult
import com.skeleton.myapplication.data.network.response.detail.DetailResponse
import com.skeleton.myapplication.data.network.response.home.HomeResponse
import kotlinx.coroutines.Dispatchers
import org.json.JSONObject

interface MainRepository{
    fun getPhotos() : LiveData<EventResult<HomeResponse>>
    fun getDetailPhotos(id:String) : LiveData<EventResult<DetailResponse>>
}
class MainRepositoryImpl(private val dataSource: MainRemoteDataSource): MainRepository {
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

    override fun getDetailPhotos(id: String): LiveData<EventResult<DetailResponse>> =
        liveData(Dispatchers.IO){
            emit(EventResult.Loading)
            try {
                val response = dataSource.getDetail(id)
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