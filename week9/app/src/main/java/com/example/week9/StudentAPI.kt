package com.example.week9

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface StudentAPI {
    @GET("student")
    //suspend fun getALlStudent() : List<Student>
    fun getAllStudent() : Call<List<Student>>
    @GET("student/{id}")
    fun getStudentById(@Path("id")id:String) : Call<Student>

    @PUT("student")
    suspend fun editStudent() : Response<StudentAPI>

    @POST("student")
    fun createStudent(@Body student: Student) : Call<Student>

    @DELETE("student")
    suspend fun deleteStudent() : Response<StudentAPI>
}