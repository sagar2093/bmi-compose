package com.github.sagar2093.bmicalculator.ui.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EmptyHeight() = Spacer(Modifier.preferredHeight(16.dp))

@Composable
fun EmptyHeight2() = Spacer(Modifier.preferredHeight(32.dp))

@Composable
fun EmptyWidth() = Spacer(Modifier.preferredWidth(16.dp))

@Composable
fun EmptyWidth2() = Spacer(Modifier.preferredWidth(32.dp))