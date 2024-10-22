package com.example.finalproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.viewmodel.DashboardResponse
import com.example.finalproject.viewmodel.EntityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: EntityRepository
) : ViewModel() {

    private val _dashboardData = MutableLiveData<DashboardResponse?>()
    val dashboardData: LiveData<DashboardResponse?> = _dashboardData

    fun fetchDashboardData(keypass: String) {
        viewModelScope.launch {
            try {
                val response = repository.getDashboardData(keypass)
                _dashboardData.postValue(response)
            } catch (e: Exception) {
                _dashboardData.postValue(null) // Handle the error, possibly logging it
            }
        }
    }
}
