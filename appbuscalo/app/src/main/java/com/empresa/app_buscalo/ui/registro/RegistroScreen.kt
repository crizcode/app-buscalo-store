package com.empresa.app_buscalo.ui.registro

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.empresa.app_buscalo.R


@Composable
fun RegistroScreen() {
    Box {
        BgdCard()
    }
}


@Composable
fun BgdCard() {
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
                contentDescription = null
            )

            ElevatedCardRegistro()
        }
    }
}

@Composable
fun ElevatedCardRegistro() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 310.dp, height = 540.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
        ) {
            Text(
                text = stringResource(id = R.string.registrar),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
            )
            RegistroDatos()
        }
    }
}

@Composable
fun RegistroDatos() {
    var txtName by rememberSaveable { mutableStateOf("") }
    var txtMail by rememberSaveable { mutableStateOf("") }
    var txtPass by rememberSaveable { mutableStateOf("") }
    var txtPassConf by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        NameTxtField(txtName) { newNameValue ->
            txtName = newNameValue
        }
        EmailTxtField(txtMail) { newMailValue ->
            txtMail = newMailValue
        }
        PassTxtField(txtPass) { newPassValue ->
            txtPass = newPassValue
        }
        PassConfTxtField(txtPassConf) { newPassValue ->
            txtPassConf = newPassValue
        }
        Spacer(modifier = Modifier.size(20.dp))
        RegistroButton()

        Spacer(modifier = Modifier.size(15.dp))
        ButtonsRedesRegistro()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NameTxtField(txtName: String, onNameValueChanged: (String) -> Unit) {
    TextField(
        value = txtName,
        onValueChange = { onNameValueChanged(it.filter { char -> char.isLetterOrDigit() }) },
        label = { Text(stringResource(id = R.string.nombres)) },
        leadingIcon = { Icon(Icons.Filled.Person, contentDescription = null) },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Text
        ),
        singleLine = true,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EmailTxtField(txtMail: String, onEmailValueChanged: (String) -> Unit) {
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
private fun PassTxtField(txtPass: String,onPasslValueChanged: (String) -> Unit) {
    TextField(
        value = txtPass,
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PassConfTxtField(txtPassConf: String,onPassConflValueChanged: (String) -> Unit) {
    TextField(
        value = txtPassConf,
        onValueChange = { onPassConflValueChanged(it) },
        label = { Text(stringResource(id = R.string.pass_conf)) },
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
private fun RegistroButton() {
    Button(onClick = { /*TODO*/ }) {
        Text(text = stringResource(id = R.string.des_registrar))
    }
}

@Composable
fun ButtonsRedesRegistro()
{
    Text(
        text = stringResource(id = R.string.desc_unirse),
        color = MaterialTheme.colorScheme.onPrimaryContainer
    )

    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    Row() {
        MyImage(id = R.drawable.ic_mail)
        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
        com.empresa.app_buscalo.ui.login.MyImage(id = R.drawable.ic_fb)
        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
        com.empresa.app_buscalo.ui.login.MyImage(id = R.drawable.ic_tlf)
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

@Preview(showBackground = true)
@Composable
fun RegistrocreenPreview(){
    BgdCard()
}
