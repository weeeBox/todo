package com.example.todo.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo.compose.home.HomeScreen
import com.example.todo.compose.itemadd.ItemAddScreen
import com.example.todo.compose.itemdetail.ItemDetailScreen

@Composable
fun ToDoApp() {
  val navController = rememberNavController()
  ToDoNavHost(
    navController = navController
  )
}

@Composable
fun ToDoNavHost(
  navController: NavHostController,
) {
  NavHost(navController = navController, startDestination = Screen.Home.route) {
    composable(route = Screen.Home.route) {
      HomeScreen()
    }
    composable(route = Screen.ItemAdd.route) {
      ItemAddScreen()
    }
    composable(
      route = Screen.ItemDetail.route,
      arguments = Screen.ItemDetail.navArguments
    ) {
      ItemDetailScreen()
    }
  }
}