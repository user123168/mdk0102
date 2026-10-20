package com.example.pr_sumatohin.data.service

import com.example.pr_sumatohin.data.model.Recipe
import retrofit2.http.Body
import retrofit2.http.POST

interface ReciepInterface {
    @POST("recipes/add")
    suspend fun addRecipe(@Body recipe: Recipe): Recipe
}