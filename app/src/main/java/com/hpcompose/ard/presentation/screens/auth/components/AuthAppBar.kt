package com.hpcompose.ard.presentation.screens.auth.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Language
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hpcompose.ard.presentation.ui.theme.ARDTheme
import com.hpcompose.ard.presentation.ui.theme.backgroundLightColor
import com.hpcompose.ard.presentation.ui.theme.primaryColor

@Composable
fun AuthAppBar(onLanguageClicked: () -> Unit) {
    TopAppBar(
        elevation = 0.dp,
        backgroundColor = backgroundLightColor,
        title = { Text(text = "") },
        actions = {
            IconButton(onClick = onLanguageClicked) {
                Icon(
                    imageVector = Icons.Outlined.Language,
                    tint = primaryColor,
                    contentDescription = "Language Change",
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun OnAuthAppBarPreview() {
    ARDTheme {
        Surface {
            AuthAppBar(
                onLanguageClicked = {}
            )
        }
    }
}