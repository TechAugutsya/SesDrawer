package com.example.sesdrawer.data.remote

import com.example.sesdrawer.data.model.NavigationResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("sesapi/navigation")
    suspend fun getNavigation(
        @Query("restApi") restApi: String = "Sesapi",
        @Query("sesapi_platform") platform: Int = 1,
        @Query("auth_token") token: String
    ): NavigationResponse
}
