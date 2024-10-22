package com.example.finalproject.viewmodel

import com.example.finalproject.models.Entity

data class DashboardResponse(
    val entities: List<Entity>,
    val entityTotal: Int
)
