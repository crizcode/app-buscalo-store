package com.empresa.app_buscalo.ui.login

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.empresa.app_buscalo.R


@Composable
fun LoginScreen() {
    Box {
            BgCard()
    }
}


@Composable
fun BgCard() {
    Surface(
        color = MaterialTheme.colorScheme.onSecondaryContainer,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.offset(y = (-120).dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = null,
            )

            ElevatedCardLogin()
        }
    }
}

@Composable
fun ElevatedCardLogin() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 310.dp, height = 540.dp)
    ) {
        Text(
            text = stringResource(id = R.string.iniciar),
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
        )
        LoginDatos ()
    }
}

@Composable
fun LoginDatos() {
    var txtMail by rememberSaveable { mutableStateOf("") }
    var txtPass by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        EmailTextField(txtMail) { newMailValue ->
            txtMail = newMailValue
        }
        PasswordTextField(txtPass) { newPassValue ->
            txtPass = newPassValue
        }
        Spacer(modifier = Modifier.size(20.dp))
        LoginButton()
        Spacer(modifier = Modifier.size(15.dp))
        ButtonsRedesLogin()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EmailTextField(txtMail: String, onEmailValueChanged: (String) -> Unit) {
    TextField(
        value = txtMail,
        onValueChange = { onEmailValueChanged(it) },
        label = { Text(stringResource(id = R.string.mail)) },
        leadingIcon = { Icon(Icons.Filled.Email, contentDescription = null) },
        singleLine = true
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PasswordTextField(txt_pass: String,onPasslValueChanged: (String) -> Unit) {
    TextField(
        value = txt_pass,
        onValueChange = { onPasslValueChanged(it) },
        label = { Text(stringResource(id = R.string.pass)) },
        leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = null) },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Text
        ),
        singleLine = true, // Esto limita el TextField a una sola línea
        visualTransformation = PasswordVisualTransformation() // Oculta el texto
    )
}
@Composable
private fun LoginButton() {
    Button(onClick = { /*TODO*/ }) {
        Text(text = stringResource(id = R.string.desc_ingresar))
    }
}

@Composable
fun ButtonsRedesLogin()
    {
    Text(
    text = stringResource(id = R.string.desc_unirse),
    color = MaterialTheme.colorScheme.onPrimaryContainer
    )

    Spacer(modifier = Modifier.padding(vertical = 8.dp))

        Row() {
            MyImage(id = R.drawable.ic_mail)
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            MyImage(id = R.drawable.ic_fb)
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            MyImage(id = R.drawable.ic_tlf)
        }
}

@Composable
fun MyImage(@DrawableRes id: Int) {
    return Image(
        painter = painterResource(id = id),
        contentDescription = null,
        modifier = Modifier.size(40.dp)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}