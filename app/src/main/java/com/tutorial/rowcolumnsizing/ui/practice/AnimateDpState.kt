package com.tutorial.rowcolumnsizing.ui.practice

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tutorial.rowcolumnsizing.R

@Composable
fun animationWithAnimateDpState() {
    val sizeStatus = rememberSaveable{ mutableStateOf(false) }

    val animateSizeDp: Dp by animateDpAsState(
        targetValue = if (sizeStatus.value) 350.dp else 100.dp,
        spring(Spring.DampingRatioHighBouncy) //tipe animasi
    )
    Image(
        painter = painterResource(id = R.drawable.steve_jobs),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(animateSizeDp)
            .clip(CircleShape)
            .border(4.dp, color = Color.Blue, CircleShape)
    )

    Button(
        onClick = { sizeStatus.value = !sizeStatus.value },
        modifier = Modifier
            .padding(top = 18.dp)
    ) {
        Text(text = "Click for change!")
    }
}