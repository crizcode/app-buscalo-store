package com.empresa.app_buscalo.ui.inicio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.empresa.app_buscalo.R
import com.empresa.app_buscalo.navigation.AppScreens


@Composable
fun InicioScreen(navController: NavHostController) {
        Inicio(navController)
}

@Composable
fun Inicio(navController: NavHostController) {
    MaterialTheme {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                //
                WaveImage()
                //
                MainImage(navController)
            }
        }
}


@Composable
fun WaveImage() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.wave_ini),
            contentDescription = "wave head",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
        )
        LogoAndAppName()
    }
}

@Composable
fun LogoAndAppName() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_ini),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        )
        Text(
            color = MaterialTheme.colorScheme.onPrimary,
            text = stringResource(id = R.string.app_name),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun MainImage(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_princ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        //
        Column(
            modifier = Modifier.offset(y = (150).dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            TextoInicio()
            ButtonsInicio(navController)
        }
    }
}

@Composable
fun TextoInicio() {
    Text(
        text = stringResource(id = R.string.desc_ini1),
        color = MaterialTheme.colorScheme.onPrimary,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
    )
    Text(
        text = stringResource(id = R.string.desc_ini2),
        color = MaterialTheme.colorScheme.onPrimary,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
    )
    Text(
        text = stringResource(id = R.string.desc_ini3),
        color = MaterialTheme.colorScheme.onPrimary,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun ButtonsInicio(navController: NavHostController) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth(0.8f))
    {
        FilledTonalButton(
            onClick = {navController.navigate(AppScreens.LoginScreen.route)},
            modifier = Modifier.padding(5.dp)
        ) {
            Text(text = stringResource(id = R.string.desc_ingresar))

        }
        FilledTonalButton(
            onClick = {navController.navigate(AppScreens.RegistroScreen.route)},
            modifier = Modifier.padding(5.dp),
        ) {
            Text(text = stringResource(id = R.string.des_registrar),
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InicioPreview() {
    val navController = rememberNavController()
    Inicio(navController)
}