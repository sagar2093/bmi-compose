package com.github.sagar2093.bmicompose.ui

import androidx.compose.Composable
import androidx.compose.remember
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Divider
import androidx.ui.material.Scaffold
import androidx.ui.material.ScaffoldState
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.outlined.ArrowBack
import androidx.ui.material.icons.outlined.Person
import androidx.ui.res.stringResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.TextUnit
import androidx.ui.unit.dp
import androidx.ui.util.fastForEachIndexed
import com.github.sagar2093.bmicalculator.ui.widgets.EmptyHeight2
import com.github.sagar2093.bmicompose.ui.widgets.RoundIconButton
import com.github.sagar2093.bmicompose.ui.widgets.RoundedCard
import com.github.sagar2093.bmicalculator.ui.widgets.Toolbar
import com.github.sagar2093.bmicompose.R
import com.github.sagar2093.bmicompose.Screen
import com.github.sagar2093.bmicompose.navigateTo
import com.github.sagar2093.bmicompose.theme.AppTheme
import com.github.sagar2093.bmicompose.theme.accentColor
import com.github.sagar2093.bmicompose.util.BmiCalculator

val textStyle = TextStyle(
    fontSize = TextUnit.Sp(16),
    color = Color.Black.copy(alpha = 0.8f)
)

@Composable
fun InfoScreen(
    scaffoldState: ScaffoldState = remember { ScaffoldState() },
    bmi: BmiCalculator
) {
    Scaffold(
        scaffoldState = scaffoldState,
        topAppBar = {
            Toolbar(
                title = stringResource(R.string.bmi_info),
                navigationIcon = {
                    RoundIconButton(
                        vectorAsset = Icons.Outlined.ArrowBack,
                        onClick = { navigateTo(Screen.Result(bmi)) }
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
private fun Content(bmi: BmiCalculator) {
    VerticalScroller(
        modifier = Modifier.padding(12.dp).fillMaxSize()
    ) {
        RoundedCard(modifier = Modifier.padding(4.dp)) {
            Row(
                modifier = Modifier.padding(24.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalGravity = Alignment.CenterVertically
            ) {
                Text(
                    text = "Your BMI",
                    style = textStyle.copy(fontSize = TextUnit.Sp(18))
                )
                Text(
                    text = bmi.bmiString,
                    style = textStyle.copy(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = TextUnit.Sp(32)
                    )
                )
                Text(
                    text = bmi.result,
                    style = textStyle.copy(
                        color = accentColor,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
        EmptyHeight2()
        val infoList = listOf(
            "Less than 18.5" to "Underweight",
            "18.5 to 24.9" to "Normal",
            "25 to 29.9" to "Overweight",
            "More than 29.9" to "Obesity"
        )
        RoundedCard(modifier = Modifier.padding(4.dp)) {
            Column {
                infoList.fastForEachIndexed { index, pair ->
                    InfoItemView(
                        info = pair,
                        hasDivider = index != infoList.lastIndex
                    )
                }
            }
        }
    }
}

@Composable()
private fun InfoItemView(info: Pair<String, String>, hasDivider: Boolean = true) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Text(
            text = info.first,
            modifier = Modifier.weight(1f),
            style = textStyle
        )
        Text(
            text = info.second,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.End,
            style = textStyle.copy(fontWeight = FontWeight.Bold)
        )
    }
    if (hasDivider) {
        Divider(modifier = Modifier.padding(horizontal = 16.dp))
    }
}

@Preview
@Composable
private fun ScreenPreview() {
    AppTheme {
        InfoScreen(bmi = BmiCalculator(202, 62))
    }
}
