package com.wrapx.imajzo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.wrapx.imajzo.animationscreen.AnimateVisibility
import com.wrapx.imajzo.ui.theme.ImajzoTheme

class DemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImajzoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val name = intent.getStringExtra("name")
                    when (name) {
                        "AnimateVisibility" -> {
                            AnimateVisibility()
                        }
                        "AnimateContent" ->{
                            AnimateContent()
                        }
                        else -> {
                            Toast.makeText(this, "It is not animation", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun AnimateContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        var isVisible by remember {
            mutableStateOf(false)
        }

        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Toggle")
        }

        AnimatedVisibility(visible = isVisible,
            enter = slideInHorizontally()+ fadeIn(),
            exit = slideOutHorizontally()+ fadeOut(),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)) {
            Box(modifier = Modifier.background(Color.Red))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ImajzoTheme {

    }
}