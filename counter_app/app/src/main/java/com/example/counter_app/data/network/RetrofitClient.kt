package com.example.counter_app.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    @Volatile
    private var INSTANT: Retrofit? = null

    private fun provideOkhttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient
            .connectTimeout(20L, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
        return okHttpClient.build()
    }

    private fun retrofitBuilder(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkhttpClient()).build()
    }
    fun getInstant() : Retrofit =
        INSTANT ?: synchronized(this){
            val instance = retrofitBuilder()
            INSTANT = instance
            instance
        }
}