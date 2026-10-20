package com.example.pr_sumatohin.data.model

data class Recipe(
    var id: Int? = null,
    var name: String,
    var ingredients: List<String>,
    var difficulty: String,
    var caloriesPerServing: Int
)
