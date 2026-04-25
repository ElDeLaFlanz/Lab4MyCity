package com.example.lab4mycity.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.example.lab4mycity.ui.navigation.BottomNavItem
import com.example.lab4mycity.ui.navigation.MyCityNavGraph
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp() {

    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Categories,
        BottomNavItem.About
    )

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {

            ModalDrawerSheet {

                NavigationDrawerItem(
                    label = { Text("Главная") },
                    selected = currentRoute == "home",
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate("home") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )

                NavigationDrawerItem(
                    label = { Text("О приложении") },
                    selected = currentRoute == "about",
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate("about") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )

                NavigationDrawerItem(
                    label = { Text("Настройки") },
                    selected = currentRoute == "settings",
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate("settings") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )

                Divider()

                listOf(
                    "coffee" to "Кофейни",
                    "parks" to "Парки",
                    "restaurants" to "Рестораны",
                    "malls" to "ТЦ",
                    "pools" to "Бассейны",
                    "gyms" to "Спортзалы"
                ).forEach { (id, title) ->

                    NavigationDrawerItem(
                        label = { Text(title) },
                        selected = false,
                        onClick = {
                            scope.launch { drawerState.close() }
                            navController.navigate("category/$id")
                        }
                    )
                }
            }
        }
    ) {

        Scaffold(

            topBar = {
                TopAppBar(
                    title = { Text("My Omsk") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "menu")
                        }
                    }
                )
            },

            bottomBar = {
                NavigationBar {items.forEach { item ->

                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(item.icon, null) },
                        label = { Text(item.title) }
                    )
                }
                }
            }

        ) { paddingValues ->

            Box(modifier = Modifier.padding(paddingValues)) {
                MyCityNavGraph(navController)
            }
        }
    }
}