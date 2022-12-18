@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.wrapx.imajzo.animationscreen

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimateContent() {
    var count by remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { count++ }, modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .absoluteOffset(y = 30.dp)) {
            Text("Add")
        }
        Button(onClick = { count-- }, modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .absoluteOffset(y = 30.dp)) {
            Text("SUB")
        }
        Box(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .absoluteOffset(y = 60.dp)) {
            AnimatedContent(
                targetState = count,
                transitionSpec = {
                    // Compare the incoming number with the previous number.
                    if (targetState > initialState) {
                        // If the target number is larger, it slides up and fades in
                        // while the initial (smaller) number slides up and fades out.
                        slideInVertically { height -> height } + fadeIn() with
                                slideOutVertically { height -> -height } + fadeOut()
                    } else {
                        // If the target number is smaller, it slides down and fades in
                        // while the initial number slides down and fades out.
                        slideInVertically { height -> -height } + fadeIn() with
                                slideOutVertically { height -> height } + fadeOut()
                    }.using(
                        // Disable clipping since the faded slide-in/out should
                        // be displayed out of bounds.
                        SizeTransform(clip = false)
                    )
                }
            ) { targetCount ->
                Text(text = "$targetCount", fontSize = 20.sp)
            }
        }
    }
}

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun StateAnimation1() {
        Column() {
            var count by remember { mutableStateOf(0) }
            Button(onClick = { count++ }) {
                Text("Add")
            }
            AnimatedContent(targetState = count) { targetCount ->
                // Make sure to use `targetCount`, not `count`.
                Text(text = "Count: $targetCount")
            }
        }
    }

@Composable
@Preview
fun AnimateContentPreview() {
    StateAnimation1()
}
