package com.example.pr_sumatohin.ui.theme.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr_sumatohin.data.model.Company
import com.example.pr_sumatohin.data.service.RetrofitClient
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    fun put(id: Int){
        viewModelScope.launch{
            try{
                val redactUser = RetrofitClient.userAPI.getUser(id)
                Log.d("","пользователь до редактирования")
                Log.d("","${redactUser.id}\n${redactUser.firstName}\n${redactUser.lastName}\n${redactUser.company.department}\n${redactUser.company.title}")
                val redactUserAfter = redactUser.copy(
                    id = 89,
                    firstName = "Олег",
                    lastName = "Павлов",
                    company = Company(department = "Интел", title = "Менеджер по продажам")
                )
                val updateUser = RetrofitClient.userAPI.putUser(id,redactUserAfter)

                Log.d("","пользователь после редактирования редактирования")
                Log.d("","${updateUser.id}\n${updateUser.firstName}\n${updateUser.lastName}\n${updateUser.company.department}\n${updateUser.company.title}")



            }
            catch (e: Exception){
                Log.e("", e.message.toString(), e)
            }

        }
    }
}