package com.github.sagar2093.bmicompose.ui.widgets

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.sagar2093.bmicompose.R
import com.github.sagar2093.bmicompose.theme.AppTheme
import com.github.sagar2093.bmicompose.theme.darkTextColor
import com.github.sagar2093.bmicompose.theme.foregroundColor

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
                    imageVector = Icons.Outlined.Notifications,
                    onClick = { })
            },
            actions = {
                RoundIconButton(imageVector = Icons.Outlined.Person, onClick = { })
            })
    }
}
