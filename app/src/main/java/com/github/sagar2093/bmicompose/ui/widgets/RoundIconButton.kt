package com.github.sagar2093.bmicompose.ui.widgets

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Icon
import androidx.ui.foundation.clickable
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.VectorAsset
import androidx.ui.layout.padding
import androidx.ui.layout.preferredSize
import androidx.ui.material.Card
import androidx.ui.material.MaterialTheme
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.outlined.Notifications
import androidx.ui.material.ripple.ripple
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.Dp
import androidx.ui.unit.dp
import com.github.sagar2093.bmicompose.theme.AppTheme

private val RippleRadius = 24.dp
private val IconButtonSizeModifier = Modifier.preferredSize(40.dp)

@Composable
fun RoundIconButton(
    vectorAsset: VectorAsset,
    onClick: () -> Unit,
    modifier: Modifier = Modifier.padding(8.dp),
    tint: Color = Color.Black.copy(alpha = 0.8f),
    backgroundColor: Color = MaterialTheme.colors.background,
    elevation: Dp = 4.dp
) {
    Card(
        modifier = modifier
            .ripple(radius = RippleRadius)
            .clickable(onClick = onClick)
            .plus(IconButtonSizeModifier),
        shape = CircleShape,
        color = backgroundColor,
        elevation = elevation
    ) {
        Icon(vectorAsset, tint = tint)
    }

}

@Preview
@Composable
private fun RoundIconPreview() {
    AppTheme {
        RoundIconButton(
            vectorAsset = Icons.Outlined.Notifications,
            onClick = {}
        )
    }
}