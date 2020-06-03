package com.github.sagar2093.bmicalculator.ui.widgets

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.layout.Spacer
import androidx.ui.layout.padding
import androidx.ui.layout.preferredHeight
import androidx.ui.layout.preferredWidth
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.unit.dp

@Composable
fun EmptyHeight() = Spacer(Modifier.preferredHeight(16.dp))

@Composable
fun EmptyHeight2() = Spacer(Modifier.preferredHeight(32.dp))

@Composable
fun EmptyWidth() = Spacer(Modifier.preferredWidth(16.dp))

@Composable
fun EmptyWidth2() = Spacer(Modifier.preferredWidth(32.dp))