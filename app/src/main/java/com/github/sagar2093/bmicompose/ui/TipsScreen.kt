package com.github.sagar2093.bmicompose.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.DirectionsBike
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.Waves
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.github.sagar2093.bmicalculator.ui.widgets.EmptyHeight
import com.github.sagar2093.bmicalculator.ui.widgets.Toolbar
import com.github.sagar2093.bmicompose.R
import com.github.sagar2093.bmicompose.Screen
import com.github.sagar2093.bmicompose.navigateTo
import com.github.sagar2093.bmicompose.theme.AppTheme
import com.github.sagar2093.bmicompose.theme.accentColor
import com.github.sagar2093.bmicompose.ui.widgets.RoundIconButton
import com.github.sagar2093.bmicompose.ui.widgets.RoundedCard

@Composable
fun TipsScreen(
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            Toolbar(
                title = stringResource(R.string.health_tips),
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
            Content()
        }
    )
}

@Composable
private fun Content() {
    ScrollableColumn(modifier = Modifier.padding(12.dp)) {
        RoundedCard(modifier = Modifier.fillMaxWidth().padding(4.dp)) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .gravity(align = Alignment.CenterHorizontally)
            ) {
                Card(
                    shape = CircleShape,
                    elevation = 4.dp,
                    backgroundColor = MaterialTheme.colors.background
                ) {
                    Card(
                        shape = CircleShape,
                        modifier = Modifier.padding(16.dp),
                        backgroundColor = accentColor
                    ) {
                        Box(
                            shape = CircleShape,
                            modifier = Modifier
                                .preferredSize(72.dp)
                                .padding(16.dp),
                            backgroundColor = MaterialTheme.colors.background
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp)
                        .gravity(Alignment.CenterVertically)
                ) {
                    Text(text = "Hi Buddy!", style = textStyle.copy(fontWeight = FontWeight.Bold))
                    Text(text = "I am your mentor to give you good tips", style = textStyle)
                }
            }
        }
        val activities = listOf(
            "Running" to Icons.Default.DirectionsRun,
            "Cycling" to Icons.Default.DirectionsBike,
            "Swimming" to Icons.Default.Waves
        )
        EmptyHeight()
        activities.forEach {
            EmptyHeight()
            ActivityCard(
                text = it.first,
                asset = it.second,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun ActivityCard(asset: VectorAsset, text: String, modifier: Modifier = Modifier) {
    RoundedCard(modifier = modifier.padding(4.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                backgroundColor = Color.LightGray.copy(alpha = 0.5f),
                shape = RoundedCornerShape(8.dp)
            ) {
                Image(
                    asset = asset,
                    modifier = Modifier.preferredSize(48.dp)
                )
            }
            Text(
                text = text,
                modifier = Modifier
                    .weight(1f)
                    .gravity(align = Alignment.CenterVertically)
                    .padding(horizontal = 16.dp),
                style = TextStyle(
                    fontSize = TextUnit.Sp(18),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black.copy(
                        alpha = 0.8f
                    )
                )
            )
            Icon(
                asset = Icons.Default.ChevronRight,
                modifier = Modifier.gravity(align = Alignment.CenterVertically),
                tint = Color.Black
            )
        }
    }
}

@Preview
@Composable
private fun ScreenPreview() {
    AppTheme {
        TipsScreen()
    }
}
