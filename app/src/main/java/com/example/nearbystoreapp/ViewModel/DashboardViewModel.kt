package com.example.nearbystoreapp.ViewModel

import androidx.lifecycle.LiveData
import com.example.nearbystoreapp.Domain.CategoryModel

class DashboardViewModel {
    private val repository= DashboardViewModel()
    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        return repository.loadCategory()
    }

}