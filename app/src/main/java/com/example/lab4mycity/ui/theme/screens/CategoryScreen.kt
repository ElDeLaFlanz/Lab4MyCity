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
fun CategoryScreen(id: String, vm: MyCityViewModel, nav: NavController) {

    val list = vm.getRecommendations(id)

    LazyColumn {
        items(list) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        nav.navigate("details/${it.id}")
                    }
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text(it.title, style = MaterialTheme.typography.titleMedium)
                    Text(it.description)
                }
            }
        }
    }
}