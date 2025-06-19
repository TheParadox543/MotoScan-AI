package com.paradox543.motoscanai.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.paradox543.motoscanai.views.HomeScreen
import com.paradox543.motoscanai.views.ResultScreen
import com.paradox543.motoscanai.views.ScanScreen

@Composable
fun NavigationGraph(){
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("scan") { ScanScreen(navController) }
        composable("result") { ResultScreen(navController) }
    }
}