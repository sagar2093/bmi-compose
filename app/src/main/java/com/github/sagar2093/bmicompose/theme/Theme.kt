package com.github.sagar2093.bmicompose.theme

import androidx.compose.Composable
import androidx.ui.graphics.Color
import androidx.ui.material.MaterialTheme
import androidx.ui.material.darkColorPalette
import androidx.ui.material.lightColorPalette

private val LightThemeColors = lightColorPalette(
    primary = backgroundColor,
    primaryVariant = foregroundColor,
    onPrimary = foregroundColor,
    secondary = backgroundColor,
    secondaryVariant = backgroundColor,
    background = backgroundColor,
    onSecondary = foregroundColor,
    error = Red800

    /* Copied from JetNews
    primary = Red700,
    primaryVariant = Red900,
    onPrimary = Color.White,
    secondary = Red700,
    secondaryVariant = Red900,
    onSecondary = Color.White,
    error = Red800*/
)

private val DarkThemeColors = darkColorPalette(
    primary = Red300,
    primaryVariant = Red700,
    onPrimary = Color.Black,
    secondary = Red300,
    onSecondary = Color.White,
    error = Red200
)

@Composable
fun AppTheme(darkTheme: Boolean = false, content: @Composable() () -> Unit) {
    // dark theme disabled
    // val darkTheme = isSystemInDarkTheme()
    MaterialTheme(
        colors = if (darkTheme) DarkThemeColors else LightThemeColors,
        typography = themeTypography,
        shapes = shapes,
        content = content
    )
}