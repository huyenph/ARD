package com.hpcompose.ard.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hpcompose.ard.R

//private val fontFamilyKulim = FontFamily(
//    listOf(
//        Font(
//            resId = R.font.kulim_park_regular
//        ),
//        Font(
//            resId = R.font.kulim_park_light,
//            weight = FontWeight.Light
//        )
//    )
//)
//
//private val fontFamilyLato = FontFamily(
//    listOf(
//        Font(
//            resId = R.font.lato_regular
//        ),
//        Font(
//            resId = R.font.lato_bold,
//            weight = FontWeight.Bold
//        )
//    )
//)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp
    ),
)