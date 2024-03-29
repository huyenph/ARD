package com.hpcompose.ard.modules.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hpcompose.ard.R
import com.hpcompose.ard.modules.auth.components.FormDivider
import com.hpcompose.ard.modules.auth.components.SocialLogin
import com.hpcompose.ard.presentation.components.ARDTextField
import com.hpcompose.ard.presentation.ui.theme.*

@Composable
fun SignInForm(onSignIn: () -> Unit = {}, onRegisterClicked: () -> Unit = {}) {
    var emailValue by remember { mutableStateOf(TextFieldValue("")) }
    var passwordValue by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Text(
            text = stringResource(id = R.string.welcome_upm),
//            style = MaterialTheme.typography.h1
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = stringResource(id = R.string.login_excerpt),
        )
        ARDTextField(
            modifier = Modifier.padding(top = 10.dp, bottom = 5.dp),
            backgroundColor = backgroundLightColor,
            textColor = textColor,
            value = emailValue,
            label = R.string.email,
            placeHolder = R.string.email_placeholder,
            keyboardType = KeyboardType.Email,
            onValueChange = { emailValue = it },
        )
        ARDTextField(
            modifier = Modifier.padding(top = 5.dp),
            backgroundColor = backgroundLightColor,
            textColor = textColor,
            value = passwordValue,
            label = R.string.password,
            placeHolder = R.string.password_placeholder,
            keyboardType = KeyboardType.Password,
            isPasswordField = true,
            onValueChange = { passwordValue = it },
        )
        Button(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            elevation = null,
            colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
            onClick = onSignIn,
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = stringResource(id = R.string.login),
            )
        }
        Text(
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 0.dp)
                .align(alignment = Alignment.End)
                .clickable(onClick = {}),
            text = stringResource(id = R.string.forgot_password),
            style = TextStyle(color = primaryColor, fontWeight = FontWeight.Bold),
        )
        FormDivider()
        SocialLogin()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = stringResource(id = R.string.new_on_platform))
            Text(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .clickable(onClick = onRegisterClicked),
                text = stringResource(id = R.string.register),
                style = TextStyle(color = primaryColor, fontWeight = FontWeight.Bold),
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFf4f5fa)
@Composable
fun OnSignInScreenPreview() {
    ARDTheme {
        SignInForm(onRegisterClicked = {})
    }
}