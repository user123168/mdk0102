package com.example.pr_sumatohin.ui.theme.viewModel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr_sumatohin.data.model.Recipe
import com.example.pr_sumatohin.data.service.RetrofitClient
import kotlinx.coroutines.launch


class RecipeViewModel: ViewModel() {
    fun createRecipe(recipe: Recipe){
        viewModelScope.launch {
            try{
                val recipeResponse = RetrofitClient.recipeAPI.addRecipe(recipe)

                Log.d(
                    "ProductViewModel",
                    "Рецепт успешно добавлен!\n" +
                            "ID: ${recipeResponse.id}\n" +
                            "Название: ${recipeResponse.name}\n" +
                            "Ингридиенты: ${recipeResponse.ingredients}\n" +
                            "Сложность: ${recipeResponse.difficulty}\n" +
                            "Калории: ${recipeResponse.caloriesPerServing}")
            }
            catch (e: Exception){
                Log.e(ContentValues.TAG,"${e.message}",e)
            }
        }
    }
}