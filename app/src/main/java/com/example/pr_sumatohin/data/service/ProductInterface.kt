package com.example.pr_sumatohin.data.service

import com.example.pr_sumatohin.data.model.Product
import com.example.pr_sumatohin.data.model.ProductList
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductInterface {
    @GET("products")
    suspend fun getProduct(): ProductList

    @DELETE ("products/{id}")
    suspend fun deleteProduct(@Path("id") id: Int): Product

}