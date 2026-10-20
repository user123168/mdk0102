package com.example.pr_sumatohin.data.service

import com.example.pr_sumatohin.data.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserInterface {
    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: Int): User
    @PUT("users/{id}")
    suspend fun putUser(@Path("id") id: Int, @Body user: User): User
}