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
import com.wrapx.imajzo.animationscreen.StateAnimation
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
                        getString(R.string.animated_visibility) -> {
                            AnimateVisibility()
                        }
                        getString(R.string.animate_as_state) -> {
                            StateAnimation()
                        }
                        getString(R.string.animate_content) -> {

                        }
                        getString(R.string.animate_Content_size) -> {

                        }
                        getString(R.string.cross_fade) -> {

                        }
                        getString(R.string.update_transition) -> {

                        }
                        getString(R.string.remember_infinite_transition) -> {

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

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ImajzoTheme {

    }
}