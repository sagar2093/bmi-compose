package com.github.sagar2093.bmicompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.animation.Crossfade
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import com.github.sagar2093.bmicompose.theme.AppTheme
import com.github.sagar2093.bmicompose.ui.HomeScreen
import com.github.sagar2093.bmicompose.ui.InfoScreen
import com.github.sagar2093.bmicompose.ui.ResultScreen
import com.github.sagar2093.bmicompose.ui.TipsScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                ComposeApp()
            }
        }
    }

    override fun onBackPressed() {
        if (ComposeStatus.currentScreen == Screen.Home) {
            super.onBackPressed()
        }
    }
}

@Composable
fun ComposeApp() {
    AppTheme {
        AppContent()
    }
}

// todo optimize navigation process
@Composable
fun AppContent() {
    Crossfade(ComposeStatus.currentScreen) { screen ->
        Surface(color = MaterialTheme.colors.background) {
            when (screen) {
                is Screen.Home -> HomeScreen()
                is Screen.Info -> InfoScreen(bmi = screen.bmi)
                is Screen.Result -> ResultScreen(bmi = screen.bmi)
                is Screen.Tips -> TipsScreen()
            }
        }
    }
}