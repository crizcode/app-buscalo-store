package com.empresa.app_buscalo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.empresa.app_buscalo.ui.inicio.InicioScreen
import com.empresa.app_buscalo.ui.login.LoginScreen
import com.empresa.app_buscalo.ui.registro.RegistroScreen
import com.empresa.app_buscalo.ui.splash.SplashScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen.route
    ) {
        composable(AppScreens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(AppScreens.InicioScreen.route) {
            InicioScreen(navController)
        }
        composable(AppScreens.LoginScreen.route) {
            LoginScreen()
        }
        composable(AppScreens.RegistroScreen.route) {
            RegistroScreen()
        }
    }
}