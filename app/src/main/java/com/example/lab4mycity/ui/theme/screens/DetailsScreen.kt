package com.example.lab4mycity.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.lab4mycity.ui.MyCityViewModel

@Composable
fun DetailsScreen(id: String, viewModel: MyCityViewModel) {

    val item = viewModel.getRecommendation(id)

    Text(text = item?.description ?: "Нет данных")
}