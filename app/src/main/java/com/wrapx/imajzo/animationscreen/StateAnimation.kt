package com.wrapx.imajzo.animationscreen

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun StateAnimation() {
    var enabled by remember {
        mutableStateOf(false)
    }
    Column {
        Button(
            onClick = { enabled = !enabled },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .absoluteOffset(y = 50.dp)
        ) {
              Text(text = "Animate State")
        }
        val alpha: Float by animateFloatAsState(if (enabled) 1f else 0.5f)
        val rotation: Float by animateFloatAsState(
            targetValue = if (enabled) 360f else 0f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200,
                easing = FastOutSlowInEasing
            )
        )

        val translate by animateDpAsState(targetValue = if (enabled) 250.dp else 0.dp)


        Box(
            Modifier
                .rotate(rotation)
                .size(60.dp)
                .graphicsLayer(alpha = alpha)
                .background(Color.Red)
                .absoluteOffset(x = translate)
        )
    }

}

@Preview
@Composable
fun StateAnimationPreview() {
    StateAnimation()
}