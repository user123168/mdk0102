package com.example.pr_sumatohin.data.service

import com.example.pr_sumatohin.data.model.ProductList
import retrofit2.http.GET

interface ProductInterface {
    @GET("products")
    suspend fun getProduct(): ProductList
}