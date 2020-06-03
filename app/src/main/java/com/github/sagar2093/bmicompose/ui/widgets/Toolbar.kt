package com.github.sagar2093.bmicalculator.ui.widgets

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.RowScope
import androidx.ui.layout.fillMaxWidth
import androidx.ui.material.TopAppBar
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.outlined.Notifications
import androidx.ui.material.icons.outlined.Person
import androidx.ui.res.stringResource
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.github.sagar2093.bmicompose.R
import com.github.sagar2093.bmicompose.theme.AppTheme
import com.github.sagar2093.bmicompose.theme.darkTextColor
import com.github.sagar2093.bmicompose.theme.foregroundColor
import com.github.sagar2093.bmicompose.ui.widgets.RoundIconButton

@Composable
fun Toolbar(
    title: String,
    navigationIcon: @Composable() (() -> Unit)? = null,
    actions: @Composable() RowScope.() -> Unit = {},
    toolbarBackground: Color = foregroundColor
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = darkTextColor
            )
        },
        navigationIcon = navigationIcon,
        actions = actions,
        elevation = 0.dp,
        backgroundColor = toolbarBackground
    )
}

@Preview
@Composable
fun ToolbarPreview() {
    AppTheme {
        Toolbar(title = stringResource(R.string.app_name),
            navigationIcon = {
                RoundIconButton(
                    vectorAsset = Icons.Outlined.Notifications,
                    onClick = { })
            },
            actions = {
                RoundIconButton(vectorAsset = Icons.Outlined.Person, onClick = { })
            })
    }
}
