package com.hpcompose.ard.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

private val DarkColorPalette = darkColors(
    primary = primaryColor,
    secondary = rust300,
    background = backgroundDarkColor,
    surface = cardDarkColor,
    onPrimary = gray900,
    onSecondary = gray900,
    onBackground = textLightColor,
    onSurface = textLightColor,
)

private val LightColorPalette = lightColors(
    primary = primaryColor,
    secondary = rust600,
    background = backgroundLightColor,
    surface = cardLightColor,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = textColor,
    onSurface = textColor,
)

private val RallyColorPalette = darkColors(
    primary = Green500,
    surface = DarkBlue900,
    onSurface = Color.White,
    background = DarkBlue900,
    onBackground = Color.White
)

@Composable
fun ARDTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}

/**
 * A theme overlay used for dialogs.
 */
//@Composable
//fun UpmThemeOverlay(content: @Composable () -> Unit) {
//    val dialogColors = darkColors(
//        primary = Color.White,
//        surface = Color.White.copy(alpha = 0.12f).compositeOver(Color.Black),
//        onSurface = Color.White
//    )
//
//    // Copy the current [Typography] and replace some text styles for this theme.
//    val currentTypography = MaterialTheme.typography
//    val dialogTypography = currentTypography.copy(
//        body2 = currentTypography.body1.copy(
//            fontWeight = FontWeight.Normal,
//            fontSize = 20.sp,
//            lineHeight = 28.sp,
//            letterSpacing = 1.sp
//        ),
//        button = currentTypography.button.copy(
//            fontWeight = FontWeight.Bold,
//            letterSpacing = 0.2.em
//        )
//    )
//    MaterialTheme(colors = dialogColors, typography = dialogTypography, content = content)
//}