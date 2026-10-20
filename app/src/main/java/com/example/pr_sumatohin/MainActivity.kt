package com.example.pr_sumatohin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pr_sumatohin.data.model.Recipe
import com.example.pr_sumatohin.ui.theme.Pr_sumatohinTheme
import com.example.pr_sumatohin.ui.theme.viewModel.ProductViewModel
import com.example.pr_sumatohin.ui.theme.viewModel.RecipeViewModel
import com.example.pr_sumatohin.ui.theme.viewModel.UserViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //pr1
            //val ProductViewModule: ProductViewModule = viewModel()
                //ProductViewModule.get()
            //pr2
            val RecipeViewModule: RecipeViewModel = viewModel()

            val recipe = Recipe(

                name = "Запеченный лосось в лимонно-горчичном маринаде",
                ingredients = listOf(
                    "Стейк или филе лосося",
                    "лимонный сок",
                    "горчица дижонская",
                    "оливковое масло",
                    "мед",
                    "чеснок",
                    "соль",
                    "свежемолотый черный перец"
                ),
               difficulty = "Сложная",
                caloriesPerServing = 420,
            )
            RecipeViewModule.createRecipe(recipe)
            //pr3
            val userViewModel: UserViewModel = viewModel()
            userViewModel.put(1)
            //pr4
            val productViewModel: ProductViewModel = viewModel()
            productViewModel.delete(3)

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pr_sumatohinTheme {
        Greeting("Android")
    }
}