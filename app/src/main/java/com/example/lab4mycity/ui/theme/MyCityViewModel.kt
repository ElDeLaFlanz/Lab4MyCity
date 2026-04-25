package com.example.lab4mycity.ui

import androidx.lifecycle.ViewModel
import com.example.lab4mycity.data.CityRepository

class MyCityViewModel : ViewModel() {

    private val repository = CityRepository()

    val categories = repository.getCategories()

    fun getRecommendations(categoryId: String) =
        repository.getRecommendationsByCategory(categoryId)

    fun getRecommendation(id: String) =
        repository.getRecommendationById(id)
}