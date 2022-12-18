package com.wrapx.imajzo.animationscreen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AnimateContentSize() {
    val message by remember { mutableStateOf("Hello") }
    var size by remember { mutableStateOf(Size(100F, 100F)) }

    Column {
        Button(onClick = {
            size = if (size.height == 100F)
                Size(200F, 200F)
            else
                Size(100F, 100F)
        }) {
            Text(text = "AnimateContentSize")
        }

        Box(
            modifier = Modifier
                .background(Color.Blue)
                .animateContentSize()
                .size(size = size.height.dp)
        ) {
            Text(text = message)
        }
    }
}

@Composable
@Preview
fun AnimateContentSizePreview() {
    AnimateContentSize()
}