package com.example.data_web.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.data_web.ui.CatFact.CatFactScreen
import com.example.data_web.ui.Welcome.Welcome

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome"){
            Welcome(onNextScreen = {navController.navigate("catFact")})
        }
        composable("catFact"){
            CatFactScreen()
        }
    }
}