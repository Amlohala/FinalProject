package com.example.finalproject.api

import com.example.finalproject.models.Entity
import com.example.finalproject.viewmodel.DashboardResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

// Data models for API
data class LoginRequest(val username: String, val password: String)
data class LoginResponse(val keypass: String)

// API service interface
interface ApiService {

    @POST("sydney/auth")  // Update the path depending on location
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @GET("dashboard/{keypass}")
    suspend fun getDashboardData(
        @Path("keypass") keypass: String
    ): DashboardResponse
}
