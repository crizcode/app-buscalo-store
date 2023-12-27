package com.empresa.app_buscalo.navigation

sealed class AppScreens(val route: String) {
    object SplashScreen : AppScreens("splash_screen")
    object InicioScreen : AppScreens("inicio_screen")
    object  LoginScreen : AppScreens( "login_screen")
    object  RegistroScreen : AppScreens("registro_screen")
}