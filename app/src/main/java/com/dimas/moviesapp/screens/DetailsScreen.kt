package com.dimas.moviesapp.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.dimas.moviesapp.MainViewModel

@Composable
fun DetailsScreen(navController: NavController, viewModel: MainViewModel, itemId: String) {
    Text("Details screen: item Id ${itemId}")
}