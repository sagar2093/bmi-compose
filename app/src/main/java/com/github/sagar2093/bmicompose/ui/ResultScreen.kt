package com.github.sagar2093.bmicompose.ui

import androidx.compose.Composable
import androidx.compose.remember
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.ContentGravity
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Card
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Scaffold
import androidx.ui.material.ScaffoldState
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.outlined.ArrowBack
import androidx.ui.material.icons.outlined.Person
import androidx.ui.res.stringResource
import androidx.ui.text.SpanStyle
import androidx.ui.text.TextStyle
import androidx.ui.text.annotatedString
import androidx.ui.text.font.FontWeight
import androidx.ui.text.withStyle
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.TextUnit
import androidx.ui.unit.dp
import com.github.sagar2093.bmicompose.ui.widgets.RoundIconButton
import com.github.sagar2093.bmicalculator.ui.widgets.Toolbar
import com.github.sagar2093.bmicompose.R
import com.github.sagar2093.bmicompose.Screen
import com.github.sagar2093.bmicompose.navigateTo
import com.github.sagar2093.bmicompose.theme.AppTheme
import com.github.sagar2093.bmicompose.theme.accentColor
import com.github.sagar2093.bmicompose.ui.widgets.RoundedButton
import com.github.sagar2093.bmicompose.util.BmiCalculator

@Composable
fun ResultScreen(
    scaffoldState: ScaffoldState = remember { ScaffoldState() },
    bmi: BmiCalculator
) {
    Scaffold(
        scaffoldState = scaffoldState,
        topAppBar = {
            Toolbar(
                title = stringResource(R.string.bmi_results),
                navigationIcon = {
                    RoundIconButton(
                        vectorAsset = Icons.Outlined.ArrowBack,
                        onClick = { navigateTo(Screen.Home) }
                    )
                },
                actions = {
                    RoundIconButton(vectorAsset = Icons.Outlined.Person, onClick = { })
                }
            )
        },
        bodyContent = {
            Content(bmi)
        }
    )
}

@Composable
private fun Content(result: BmiCalculator) {
    Column(
        modifier = Modifier.padding(16.dp).fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        val childModifier = Modifier.gravity(align = Alignment.CenterHorizontally)
        Card(
            shape = CircleShape,
            elevation = 4.dp,
            color = MaterialTheme.colors.background,
            modifier = childModifier
        ) {
            Card(
                shape = CircleShape,
                modifier = Modifier.padding(32.dp),
                color = accentColor
            ) {
                Box(
                    shape = CircleShape,
                    modifier = Modifier
                        .preferredSize(112.dp)
                        .padding(8.dp),
                    backgroundColor = MaterialTheme.colors.background,
                    gravity = ContentGravity.Center
                ) {
                    Text(
                        text = result.bmiString,
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black.copy(alpha = 0.8f),
                            fontSize = TextUnit.Sp(32)
                        )
                    )
                }
            }
        }
        Text(
            style = textStyle.copy(
                fontSize = TextUnit.Sp(18)
            ),
            text = annotatedString {
                append("You have ")
                withStyle(
                    style = SpanStyle(
                        color = accentColor,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(result.result)
                }
                append(" body weight!")
            },
            modifier = childModifier
        )
        RoundedButton(
            text = "Details",
            onClick = { navigateTo(Screen.Info(result)) },
            modifier = childModifier.preferredWidth(120.dp),
            backGroundColor = MaterialTheme.colors.background,
            contentColor = Color.Black.copy(alpha = 0.8f)
        )
    }
}

@Preview
@Composable
private fun ScreenPreview() {
    AppTheme {
        ResultScreen(bmi = BmiCalculator(202, 62))
    }
}
