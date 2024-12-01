package com.example.counter_app.repository

import com.example.counter_app.data.DataState
import com.example.counter_app.data.network.ApiService
import com.example.counter_app.model.CategoryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryRepository(private val apiService: ApiService) {
    suspend fun getCategories() : DataState<CategoryResponse> {
        return withContext(Dispatchers.IO){
            try {
                DataState.Success(apiService.getCategory())
            }catch (e: Exception){
                DataState.Error(e)
            }
        }
    }
}