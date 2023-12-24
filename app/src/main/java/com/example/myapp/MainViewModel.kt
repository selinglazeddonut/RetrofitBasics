package com.example.myapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel:ViewModel()  {

    private val _post =MutableLiveData<MyPost>()
    val post:LiveData<MyPost>
        get()=_post

    private val _isLoading=MutableLiveData<Boolean>()
   val isLoading:LiveData<Boolean>
    get() = _isLoading


    init {
        fetchPost()
    }

    fun fetchPost() {
        viewModelScope.launch {
            _isLoading.value = true
            delay(2000)
            try {
                val response = RetrofitInstance.api.fetchPost()
                if (response.isSuccessful) {
                    response.body()?.let { post ->
                        _post.value = post
                    }
                } else {
                    // Handle unsuccessful response
                    Log.e("API Hatası", "Hata: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                // Handle exceptions
                Log.e("API İstisnası", "İstisna: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }

}