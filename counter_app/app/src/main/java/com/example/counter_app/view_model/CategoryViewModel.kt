package com.example.counter_app.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.counter_app.data.DataState
import com.example.counter_app.data.network.ApiService
import com.example.counter_app.data.network.RetrofitClient
import com.example.counter_app.model.CategoryResponse
import com.example.counter_app.repository.CategoryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel() {
    private val categoryRepo = CategoryRepository(
        RetrofitClient.getInstant().create(ApiService::class.java)
    )

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean>
        get() = _loading

    fun showLoading() {
        _loading.value = true
    }

    fun hideLoading() {
        _loading.value = false
    }

    private val _category = MutableLiveData<CategoryResponse>()
    val category: LiveData<CategoryResponse> get() = _category

    fun getListCategory() {
        viewModelScope.launch {
            if (loading.value == true) {
                showLoading()
            }
            when (val response = categoryRepo.getCategories()) {
                is DataState.Success -> {
                    _category.value = response.data
                    hideLoading()
                }

                is DataState.Error -> {
                    hideLoading()
                }
            }
        }
    }
}