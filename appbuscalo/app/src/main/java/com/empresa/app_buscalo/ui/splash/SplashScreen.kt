package com.empresa.app_buscalo.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.empresa.app_buscalo.R
import com.empresa.app_buscalo.navigation.AppScreens
import kotlinx.coroutines.delay



@Composable
fun SplashScreen(navController: NavHostController) {

  LaunchedEffect(key1=true){
        delay(3000)
        navController.popBackStack()
        navController.navigate(AppScreens.InicioScreen.route)

    }

    Splash()
}

@Composable
fun Splash() {
   Surface (
       modifier = Modifier.fillMaxSize(),
       color = MaterialTheme.colorScheme.inverseOnSurface
   ) {
    Column (modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ){
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo empresa",
            Modifier.size(120.dp, 120.dp))
            Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontWeight = FontWeight.Bold)
    }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    Splash()
}
