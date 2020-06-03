package com.github.sagar2093.bmicompose.ui.widgets

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.padding
import androidx.ui.material.Card
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.Dp
import androidx.ui.unit.dp
import com.github.sagar2093.bmicompose.theme.AppTheme
import com.github.sagar2093.bmicompose.ui.textStyle

@Composable
fun RoundedCard(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.background,
    elevation: Dp = 4.dp,
    content: @Composable() () -> Unit
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        color = color,
        elevation = elevation
    ) {
        content()
    }
}

@Preview
@Composable
private fun RoundedCardPreview() {
    AppTheme {
        RoundedCard {
            Text(text = "RoundedCard", modifier = Modifier.padding(8.dp), style = textStyle)
        }
    }
}

