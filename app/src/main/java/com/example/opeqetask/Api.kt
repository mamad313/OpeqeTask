package com.example.opeqetask

import com.example.opeqetask.models.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface Api {

    @GET(".")
    suspend fun getUsers(@Query("results") result: Int): UserResponse

}