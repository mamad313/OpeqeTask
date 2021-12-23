package com.example.opeqetask.repository

import com.example.opeqetask.Api
import retrofit2.http.Query

class Repository(private val api: Api) {
    suspend fun getUsers() = api.getUsers(10)
}