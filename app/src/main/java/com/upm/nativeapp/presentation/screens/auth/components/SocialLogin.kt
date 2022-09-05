package com.upm.nativeapp.presentation.screens.auth.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.upm.nativeapp.R
import com.upm.nativeapp.presentation.ui.theme.UpmTheme

@Composable
fun SocialLogin(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = { }) {
            Image(
                painter = painterResource(id = R.drawable.ic_facebook),
                contentDescription = stringResource(id = R.string.facebook_description),
            )
        }
        IconButton(onClick = { }) {
            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = stringResource(id = R.string.facebook_description),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OnSocialLogin() {
    UpmTheme {
        SocialLogin()
    }
}