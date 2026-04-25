package com.example.lab4mycity.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomNavItem("home", "Главная", Icons.Default.Home)
    object Categories : BottomNavItem("categories", "Категории", Icons.Default.List)
    object About : BottomNavItem("about", "О приложении", Icons.Default.Info)
}