package com.github.sagar2093.bmicompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.sagar2093.bmicompose.ui.widgets.Toolbar
import com.github.sagar2093.bmicompose.R
import com.github.sagar2093.bmicompose.Screen
import com.github.sagar2093.bmicompose.navigateTo
import com.github.sagar2093.bmicompose.theme.AppTheme
import com.github.sagar2093.bmicompose.theme.accentColor
import com.github.sagar2093.bmicompose.ui.widgets.RoundIconButton
import com.github.sagar2093.bmicompose.ui.widgets.RoundedButton
import com.github.sagar2093.bmicompose.util.BmiCalculator

@Composable
fun ResultScreen(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    bmi: BmiCalculator
) {
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            Toolbar(
                title = stringResource(R.string.bmi_results),
                navigationIcon = {
                    RoundIconButton(
                        imageVector = Icons.Outlined.ArrowBack,
                        onClick = { navigateTo(Screen.Home) }
                    )
                },
                actions = {
                    RoundIconButton(imageVector = Icons.Outlined.Person, onClick = { })
                }
            )
        },
        content = {
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
        val childModifier = Modifier.align(Alignment.CenterHorizontally)
        Card(
            shape = CircleShape,
            elevation = 4.dp,
            backgroundColor = MaterialTheme.colors.background,
            modifier = childModifier
        ) {
            Card(
                shape = CircleShape,
                modifier = Modifier.padding(32.dp),
                backgroundColor = accentColor
            ) {
                Box(
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.background,shape = CircleShape)
                        .size(112.dp)
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = result.bmiString,
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black.copy(alpha = 0.8f),
                            fontSize = 32.sp
                        )
                    )
                }
            }
        }
        Text(
            style = textStyle.copy(
                fontSize = 18.sp
            ),
            text = buildAnnotatedString {
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
            modifier = childModifier.width(120.dp),
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
