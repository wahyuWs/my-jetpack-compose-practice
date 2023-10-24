package com.tutorial.rowcolumnsizing.ui.practice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tutorial.rowcolumnsizing.R

@Composable
fun showImage() {
    Image(
        painter = painterResource(id = R.drawable.steve_jobs),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(160.dp)
            .clip(CircleShape) // clip to the circle shape
            .border(4.dp, Color.Blue, CircleShape)
            .background(Color.White)
    )
}