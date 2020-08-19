package com.github.sagar2093.bmicompose.ui.widgets

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.github.sagar2093.bmicalculator.ui.widgets.EmptyWidth
import com.github.sagar2093.bmicompose.theme.AppTheme
import com.github.sagar2093.bmicompose.theme.accentColor
import com.github.sagar2093.bmicompose.theme.backgroundColor
import com.github.sagar2093.bmicompose.theme.foregroundColor

private val IconButtonSizeModifier = Modifier.preferredHeight(50.dp)

@Composable
fun RoundedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp,
    backGroundColor: Color = accentColor,
    contentColor: Color = foregroundColor
) {
    Button(
        onClick = onClick,
        modifier = modifier + IconButtonSizeModifier,
        shape = RoundedCornerShape(16.dp),
        backgroundColor = backGroundColor,
        contentColor = contentColor,
        elevation = elevation
    ) {
        Text(text = text, fontSize = TextUnit.Companion.Sp(18))
    }
}

@Composable
fun RoundedToggleButton(
    state: MutableState<Boolean>,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    activeColor: Color = accentColor,
    inactiveColor: Color = backgroundColor
) {
    Button(
        onClick = onClick,
        modifier = modifier then  IconButtonSizeModifier,
        shape = RoundedCornerShape(16.dp),
        backgroundColor = if (state.value) activeColor else inactiveColor,
        contentColor = if (state.value) foregroundColor else Color.Gray
    ) {
        Text(text = text, fontSize = TextUnit.Sp(18))
    }
}

@Preview
@Composable
private fun ButtonPreview() {
    AppTheme {
        RoundedButton(text = "Button", onClick = {})
    }
}

@Preview
@Composable
private fun ToggleButtonPreview() {
    AppTheme {
        val trueState = mutableStateOf(true)
        val falseState = mutableStateOf(false)
        Row {
            RoundedToggleButton(state = trueState, text = "True", onClick = {})
            EmptyWidth()
            RoundedToggleButton(state = falseState, text = "False", onClick = {})
        }

    }
}