package com.github.sagar2093.bmicompose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.sagar2093.bmicompose.ui.widgets.EmptyHeight2
import com.github.sagar2093.bmicompose.R
import com.github.sagar2093.bmicompose.Screen
import com.github.sagar2093.bmicompose.navigateTo
import com.github.sagar2093.bmicompose.theme.AppTheme
import com.github.sagar2093.bmicompose.theme.accentColor
import com.github.sagar2093.bmicompose.ui.widgets.RoundIconButton
import com.github.sagar2093.bmicompose.ui.widgets.RoundedCard
import com.github.sagar2093.bmicompose.ui.widgets.Toolbar
import com.github.sagar2093.bmicompose.util.BmiCalculator

val textStyle = TextStyle(
    fontSize = 16.sp,
    color = Color.Black.copy(alpha = 0.8f)
)

@Composable
fun InfoScreen(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    bmi: BmiCalculator
) {
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            Toolbar(
                title = stringResource(R.string.bmi_info),
                navigationIcon = {
                    RoundIconButton(
                        imageVector = Icons.Outlined.ArrowBack,
                        onClick = { navigateTo(Screen.Result(bmi)) }
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
private fun Content(bmi: BmiCalculator) {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        RoundedCard(modifier = Modifier.padding(4.dp)) {
            Row(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Your BMI",
                    style = textStyle.copy(fontSize = 18.sp)
                )
                Text(
                    text = bmi.bmiString,
                    style = textStyle.copy(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 32.sp
                    )
                )
                Text(
                    text = bmi.result,
                    style = textStyle.copy(
                        color = accentColor,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
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
                infoList.forEachIndexed { index, pair ->
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
