package com.upm.ard.presentation.screens.auth.components

import com.upm.ard.R
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun FormDivider(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier.width(configuration.screenWidthDp.dp / 3),
            thickness = 1.dp,
            color = Color.Gray,
        )
        Text(
            modifier = Modifier.padding(horizontal = 10.dp),
            text = stringResource(id = R.string.or)
        )
        Divider(
            modifier = Modifier.width(configuration.screenWidthDp.dp / 3),
            thickness = 1.dp,
            color = Color.Gray,
        )
    }
}