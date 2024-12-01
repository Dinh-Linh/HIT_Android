package com.example.counter_app.data.network

import com.example.counter_app.model.CategoryResponse
import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    suspend fun getCategory(): CategoryResponse
}