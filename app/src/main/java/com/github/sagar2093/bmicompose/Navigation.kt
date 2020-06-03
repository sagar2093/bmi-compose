package com.github.sagar2093.bmicompose

import androidx.compose.Model
import androidx.compose.frames.ModelList
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

// todo replace @Model implementation
@Model
object ComposeStatus {
    var previousScreen: Screen? = null
    var currentScreen: Screen =
        Screen.Home
    val favorites = ModelList<String>()
    val selectedTopics = ModelList<String>()
}

/**
 * Temporary solution pending navigation support.
 */
fun navigateTo(destination: Screen) {
    ComposeStatus.currentScreen = destination
}
