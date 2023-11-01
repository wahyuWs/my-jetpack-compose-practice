package com.tutorial.rowcolumnsizing.ui.practice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun BoxWithConstraintLayout() {
    val constraintSet = ConstraintSet {
        val blueBox = createRefFor("bluebox")
        val yellowBox = createRefFor("yellowbox")

        constrain(blueBox) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(yellowBox) {
            top.linkTo(parent.top)
            start.linkTo(blueBox.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
    }

    ConstraintLayout(constraintSet, modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .background(Color.Blue)
            .layoutId("bluebox")
        )
        Box(modifier = Modifier
            .background(Color.Yellow)
            .layoutId("yellowbox")
        )
    }
}