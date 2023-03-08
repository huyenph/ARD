package com.hpcompose.ard.presentation.screens.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
import com.hpcompose.ard.presentation.components.UpmTextField
import com.hpcompose.ard.presentation.screens.auth.components.FormDivider
import com.hpcompose.ard.presentation.screens.auth.components.SocialLogin
import com.hpcompose.ard.presentation.ui.theme.*

@Composable
fun SignUpForm(onSignUp: () -> Unit = {}, onLoginClicked: () -> Unit = {}) {
    var usernameValue by remember { mutableStateOf(TextFieldValue("")) }
    var emailValue by remember { mutableStateOf(TextFieldValue("")) }
    var passwordValue by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Text(
            text = stringResource(id = R.string.adventure_start_here),
            style = MaterialTheme.typography.h1
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = stringResource(id = R.string.register_excerpt),
        )
        UpmTextField(
            modifier = Modifier.padding(top = 10.dp, bottom = 5.dp),
            backgroundColor = backgroundLightColor,
            textColor = textColor,
            value = usernameValue,
            label = R.string.username,
            placeHolder = R.string.username_placeholder,
            keyboardType = KeyboardType.Text,
            onValueChange = { usernameValue = it },
        )
        UpmTextField(
            modifier = Modifier.padding(top = 10.dp, bottom = 5.dp),
            backgroundColor = backgroundLightColor,
            textColor = textColor,
            value = emailValue,
            label = R.string.email,
            placeHolder = R.string.email_placeholder,
            keyboardType = KeyboardType.Email,
            onValueChange = { emailValue = it },
        )
        UpmTextField(
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
            colors = ButtonDefaults.buttonColors(backgroundColor = primaryColor),
            onClick = onSignUp,
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = stringResource(id = R.string.register),
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = stringResource(id = R.string.i_agree_to))
            Text(
                modifier = Modifier.padding(horizontal = 5.dp),
                text = stringResource(id = R.string.privacy_policy),
                style = TextStyle(color = primaryColor, fontWeight = FontWeight.Bold),
            )
        }
        FormDivider()
        SocialLogin()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(id = R.string.already_have_account),
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .clickable(onClick = onLoginClicked),
                text = stringResource(id = R.string.login_instead),
                style = TextStyle(color = primaryColor, fontWeight = FontWeight.Bold),
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFf4f5fa)
@Composable
fun OnSignUpFormPreview() {
    ARDTheme {
        SignUpForm(onLoginClicked = {})
    }
}