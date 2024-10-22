package com.example.finalproject.viewmodel

import com.example.finalproject.api.ApiService
import com.example.finalproject.viewmodel.DashboardResponse
import javax.inject.Inject

class EntityRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getDashboardData(keypass: String): DashboardResponse {
        return apiService.getDashboardData(keypass)
    }
}
