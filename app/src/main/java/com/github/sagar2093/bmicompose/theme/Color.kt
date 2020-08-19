package com.github.sagar2093.bmicompose.theme

import androidx.compose.foundation.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

val Red200 = Color(0xfff297a2)
val Red300 = Color(0xffea6d7e)
val Red700 = Color(0xffdd0d3c)
val Red800 = Color(0xffd00036)
val Red900 = Color(0xffc20029)

val purple200 = Color(0xFFBB86FC)
val purple500 = Color(0xFF6200EE)
val purple700 = Color(0xFF3700B3)
val teal200 = Color(0xFF03DAC5)

// Referenced from https://github.com/alirzadev/BMI-Calculator/blob/master/lib/utilities/constants.dart
val backgroundColor = Color(0xFFF0EEF3)
val darkTextColor = Color(0xFF5B6275)
val lightTextColor = Color.Gray
val foregroundColor = Color(0xFFF0EEF3)
val accentColor = Color(0xFF59CAE2)

// Palette colors referenced from https://dribbble.com/shots/11368106-BMI-Calculator-App-Neumorphism
val color1 = Color(0xFFD5D6D7)
val color2 = Color(0xFFB9C3C9)
val color3 = Color(0xFF2CA1BC)
val color4 = Color(0xFF727789)
val color5 = Color(0xFF4D5468)

val whitishColor = color1
val whitishVariantColor = color2
val bluishColor = color3
val darkVariantColor = color5
val darkColor = color4

@Preview
@Composable
private fun ColorDemo() {
    val colors = listOf(
        backgroundColor, darkTextColor, lightTextColor, foregroundColor, accentColor,
        whitishColor, whitishVariantColor, bluishColor, darkVariantColor, darkColor
    )
    Column {
        colors.forEach {
            Box(backgroundColor = it, modifier = Modifier.fillMaxWidth().preferredHeight(16.dp))
        }
    }
}
