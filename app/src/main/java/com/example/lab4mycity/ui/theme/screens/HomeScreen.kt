package com.example.lab4mycity.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lab4mycity.ui.MyCityViewModel

@Composable
fun HomeScreen(
    viewModel: MyCityViewModel,
    navController: NavController
) {

    val categories = viewModel.categories

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {

        item {
            Text(
                text = "Категории",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(16.dp)
            )
        }

        items(categories) { category ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 6.dp)
                    .clickable {
                        navController.navigate("category/${category.id}")
                    },
                elevation = CardDefaults.cardElevation(4.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = category.title,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Нажмите, чтобы посмотреть места",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}