package com.upm.nativeapp.presentation.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.upm.nativeapp.R
import com.upm.nativeapp.presentation.components.BaseScaffold
import com.upm.nativeapp.presentation.components.UpmTextField
import com.upm.nativeapp.presentation.screens.auth.components.AuthAppBar
import com.upm.nativeapp.presentation.screens.auth.components.FormDivider
import com.upm.nativeapp.presentation.screens.auth.components.SocialLogin
import com.upm.nativeapp.presentation.ui.theme.UpmTheme
import com.upm.nativeapp.presentation.ui.theme.backgroundLightColor
import com.upm.nativeapp.presentation.ui.theme.primaryColor
import com.upm.nativeapp.presentation.ui.theme.textColor

@Composable
fun SignInScreen(onRegisterClicked: (Int) -> Unit = {}) {
    var emailValue by remember { mutableStateOf(TextFieldValue("")) }
    var passwordValue by remember { mutableStateOf(TextFieldValue("")) }
    BaseScaffold(
        backgroundColor = backgroundLightColor,
        topBar = { AuthAppBar(onLanguageClicked = {}) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Text(
                text = stringResource(id = R.string.welcome_upm),
                style = MaterialTheme.typography.h1
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = stringResource(id = R.string.login_excerpt),
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
                onClick = {},
            ) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = stringResource(id = R.string.login),
                )
            }
            ClickableText(
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 0.dp)
                    .align(alignment = Alignment.End),
                text = AnnotatedString(
                    stringResource(id = R.string.forgot_password),
                    spanStyle = SpanStyle(color = primaryColor, fontWeight = FontWeight.Bold),
                ),
                onClick = {},
            )
            FormDivider()
            SocialLogin(modifier = Modifier.fillMaxWidth())
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(id = R.string.new_on_platform),
                )
                ClickableText(
                    modifier = Modifier.padding(horizontal = 5.dp),
                    text = AnnotatedString(
                        stringResource(id = R.string.register),
                        spanStyle = SpanStyle(color = primaryColor, fontWeight = FontWeight.Bold),
                    ),
                    onClick = onRegisterClicked,
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFf4f5fa)
@Composable
fun OnSignInScreenPreview() {
    UpmTheme {
        SignInScreen(onRegisterClicked = {})
    }
}