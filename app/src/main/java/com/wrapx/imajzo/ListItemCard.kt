package com.wrapx.imajzo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListItemCard(data: ListItemData, modifier: Modifier = Modifier, onClick: (() -> Unit)? = null ) {
    Card(
        modifier = Modifier.padding(vertical = 3.dp, horizontal = 8.dp),
        elevation = 1.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(
                        color = Color.Black
                    ),
                    onClick = {
                        onClick?.invoke()
                    }
                )
                .padding(10.dp)

        ) {
            Text(
                text = data.animationName,
                modifier = Modifier.align(Alignment.Center),
                fontSize = 20.sp,
                fontFamily = FontFamily.Monospace
            )
        }
    }
}

@Preview
@Composable
fun ListItemCardPreview(){
    ListItemCard(data = ListItemData(AnimationType.ANIMATE_VISIBILITY, "Animation1"))
}