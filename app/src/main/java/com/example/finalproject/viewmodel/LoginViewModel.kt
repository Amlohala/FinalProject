package com.example.finalproject.viewmodel

import androidx.lifecycle.*
import com.example.finalproject.viewmodel.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _loginResult = MutableLiveData<Result<String>>()
    val loginResult: LiveData<Result<String>> = _loginResult

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = repository.login(username, password)
                _loginResult.value = Result.success(response.keypass)
            } catch (e: Exception) {
                _loginResult.value = Result.failure(e)
            }
        }
    }
}
