package com.example.pr_sumatohin.ui.theme.viewModel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr_sumatohin.data.service.RetrofitClient
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    fun get(){
        viewModelScope.launch {
            try{
                val ProductList = RetrofitClient.retrofitAPI.getProduct()
                val products = ProductList.products
                for (product in products) {
                    Log.d(ContentValues.TAG,
                        "Название:${product.title}, " +
                                "Описание:${product.description}," +
                                "Категория:${product.category}," +
                                "Цена: ${product.price}," +
                                "Рейтинг: ${product.rating}," +
                                "Бренд: ${product.brand},")
                }

            }
            catch (e: Exception){
                Log.e(ContentValues.TAG,"${e.message}",e)
            }
        }
    }
}