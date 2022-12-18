package com.wrapx.imajzo.animationscreen

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CrossFadeAnimation() {
    var currentPage = remember {
        mutableStateOf("A")
    }
    Column {
        Button(onClick = {
            currentPage.value = if (currentPage.value == "A") {
                "B"
            } else {
                "A"
            }
        }) {
            Text(text = "Change")

        }
        Crossfade(targetState = currentPage) { screen ->
            when (screen.value) {
                "A" -> PagesA()
                "B" -> PagesB()
            }
        }
    }

}

@Composable
fun PagesA() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text("Page A", modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun PagesB() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Text("Page B", modifier = Modifier.align(Alignment.Center))
    }
}


@Preview
@Composable
fun CrossFadeAnimationPreview() {
    CrossFadeAnimation()
}