package com.github.sagar2093.bmicompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.DirectionsBike
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.Waves
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.sagar2093.bmicalculator.ui.widgets.EmptyHeight
import com.github.sagar2093.bmicompose.R
import com.github.sagar2093.bmicompose.Screen
import com.github.sagar2093.bmicompose.navigateTo
import com.github.sagar2093.bmicompose.theme.AppTheme
import com.github.sagar2093.bmicompose.theme.accentColor
import com.github.sagar2093.bmicompose.ui.widgets.RoundIconButton
import com.github.sagar2093.bmicompose.ui.widgets.RoundedCard
import com.github.sagar2093.bmicompose.ui.widgets.Toolbar

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
            Content()
        }
    )
}

@Composable
private fun Content() {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .verticalScroll(rememberScrollState())
    ) {
        RoundedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
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
                            modifier = Modifier
                                .background(
                                    color = MaterialTheme.colors.background,
                                    shape = CircleShape
                                )
                                .size(72.dp)
                                .padding(16.dp)
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp)
                        .align(Alignment.CenterVertically)
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
                imageVector = it.second,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun ActivityCard(imageVector: ImageVector, text: String, modifier: Modifier = Modifier) {
    RoundedCard(modifier = modifier.padding(4.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                Modifier.background(
                    color = Color.LightGray.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(8.dp)
                )
            ) {
                Image(
                    imageVector = imageVector,
                    contentDescription = null,
                    modifier = Modifier.size(48.dp)
                )
            }
            Text(
                text = text,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .padding(horizontal = 16.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black.copy(
                        alpha = 0.8f
                    )
                )
            )
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterVertically),
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
