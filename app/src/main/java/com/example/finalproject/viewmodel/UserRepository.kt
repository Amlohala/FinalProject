package com.example.finalproject.viewmodel

import com.example.finalproject.api.ApiService
import com.example.finalproject.api.LoginRequest
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun login(username: String, password: String) =
        apiService.login(LoginRequest(username, password))
}