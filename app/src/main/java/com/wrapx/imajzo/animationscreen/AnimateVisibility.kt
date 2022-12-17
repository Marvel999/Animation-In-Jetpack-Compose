package com.wrapx.imajzo.animationscreen

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AnimateVisibility(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        var isVisible by remember {
            mutableStateOf(false)
        }

        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Toggle")
        }
        val density = LocalDensity.current
        AnimatedVisibility(visible = isVisible,
            enter = slideInVertically {
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(
                expandFrom = Alignment.Top
            ) + fadeIn(
                initialAlpha = 0.3f
            ),
            exit = slideOutVertically() + shrinkVertically() + fadeOut(),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)) {
            Box(modifier = Modifier.background(Color.Red))
        }
    }
}

@Composable
fun AnimateVisibility1(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        var isVisible by remember {
            mutableStateOf(false)
        }

        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Toggle")
        }

        AnimatedVisibility(
            visible = isVisible,
            enter = slideInHorizontally() + fadeIn(),
            exit = slideOutHorizontally() + fadeOut(),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(modifier = Modifier.background(Color.Red))
        }
    }
}

@Preview
@Composable
fun AnimateVisibilityPreview(){
    AnimateVisibility()
}