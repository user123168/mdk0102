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
    fun delete(id: Int){
        viewModelScope.launch {
            try {
                val delete  = RetrofitClient.retrofitAPI.deleteProduct(id)
                Log.d("", "Продукт удален:\n" +
                        "ID: ${delete.id}\n" +
                        "Название: ${delete.title}\n" +
                        "Описание: ${delete.description}\n" +
                        "Категория: ${delete.category}\n" +
                        "Цена: ${delete.price}\n" +
                        "Рейтинг: ${delete.rating}\n" +
                        "Создатель: ${delete.brand}\n")
            } catch (e: Exception) {
                Log.e("", "Произошла ошибка при удалении: ${e.message}", e)
            }
        }

    }
}