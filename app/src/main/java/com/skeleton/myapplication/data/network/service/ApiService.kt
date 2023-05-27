package com.skeleton.myapplication.data.network.service

import com.skeleton.myapplication.data.network.response.home.HomeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService{
    @GET("photos")
    suspend fun getPhotos(
        @Query("client_id") client_id: String = API_KEY
    ) : Response<HomeResponse>
}
const val API_KEY= "ioan-1fwj7XkcjbFf_wTWQrEq7E_CJe7RvMjYnDlJ_g"