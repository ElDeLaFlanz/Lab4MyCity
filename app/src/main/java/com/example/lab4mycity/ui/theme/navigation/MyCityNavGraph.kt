package com.example.lab4mycity.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.lab4mycity.ui.MyCityViewModel
import com.example.lab4mycity.ui.screens.*

@Composable
fun MyCityNavGraph(navController: NavHostController) {

    val viewModel: MyCityViewModel = viewModel()

    NavHost(navController, startDestination = "home") {

        composable("home") {
            HomeScreen(viewModel, navController)
        }

        composable("categories") {
            HomeScreen(viewModel, navController)
        }

        composable("about") {
            AboutScreen()
        }
        composable("settings") {
            SettingsScreen()
        }

        composable("category/{categoryId}") {
            val id = it.arguments?.getString("categoryId")!!
            CategoryScreen(id, viewModel, navController)
        }

        composable("details/{id}") {
            val id = it.arguments?.getString("id")!!
            DetailsScreen(id, viewModel)
        }
    }
}