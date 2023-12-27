package com.empresa.app_buscalo.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen() {
        NavHomeScreen()
}


@Composable
fun NavHomeScreen (){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        // Botón de hamburguesa en la esquina izquierda
        IconButton(
            onClick = { /* Manejar clic en el botón de hamburguesa */ },
            modifier = Modifier
                .align(Alignment.Start)
                .padding(16.dp)
        ) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "Hamburguesa")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PruebaScreenPreview(){
    NavHomeScreen()
}