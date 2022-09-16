package com.upm.ard.presentation.components

import com.upm.ard.R
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.upm.ard.presentation.ui.theme.UpmTheme
import com.upm.ard.presentation.ui.theme.primaryColor

@Composable
fun UpmTextField(
    modifier: Modifier = Modifier,
    value: TextFieldValue = TextFieldValue(""),
    @StringRes label: Int,
    @StringRes placeHolder: Int = R.string.default_placeholder,
    backgroundColor: Color = MaterialTheme.colors.background,
    textColor: Color = MaterialTheme.colors.onBackground,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordField: Boolean = false,
    onValueChange: (value: TextFieldValue) -> Unit,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = stringResource(id = label)) },
        placeholder = { Text(text = stringResource(id = placeHolder)) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = backgroundColor,
            textColor = textColor,
            unfocusedLabelColor = primaryColor,
            unfocusedIndicatorColor = primaryColor,
            placeholderColor = Color.Gray,
        ),
        visualTransformation = if (isPasswordField)
            PasswordVisualTransformation()
        else VisualTransformation.None,
        modifier = modifier.fillMaxWidth(),
    )
}

@Preview(showBackground = true)
@Composable
private fun OnUpmTextFieldPreview() {
    UpmTheme {
        UpmTextField(
            value = TextFieldValue("email@gmail.com"),
            label = R.string.placeholder_search,
            placeHolder = R.string.placeholder_search,
            onValueChange = {},
        )
    }
}
