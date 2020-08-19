package com.github.sagar2093.bmicompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.github.sagar2093.bmicompose.util.BmiCalculator

/**
 * Class defining the screens we have in the app: home, article details and interests
 */
sealed class Screen {
    object Home : Screen()
    data class Info(val bmi: BmiCalculator) : Screen()
    data class Result(val bmi: BmiCalculator) : Screen()
    object Tips : Screen()
}

object ComposeStatus {
    var currentScreen by mutableStateOf<Screen>(Screen.Home)
    var previousScreen by mutableStateOf<Screen?>(null)
}

/**
 * Temporary solution pending navigation support.
 */
fun navigateTo(destination: Screen) {
    ComposeStatus.currentScreen = destination
}
