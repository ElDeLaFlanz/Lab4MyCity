package com.example.lab4mycity.data

class CityRepository {

    fun getCategories() = LocalCityDataProvider.categories

    fun getRecommendationsByCategory(categoryId: String) =
        LocalCityDataProvider.recommendations.filter {
            it.categoryId == categoryId
        }

    fun getRecommendationById(id: String) =
        LocalCityDataProvider.recommendations.find { it.id == id }
}