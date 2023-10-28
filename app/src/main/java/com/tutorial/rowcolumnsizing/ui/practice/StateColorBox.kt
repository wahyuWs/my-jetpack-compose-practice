package com.tutorial.rowcolumnsizing.ui.practice

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import java.util.Random

//kode dibawah dipanggil didalam func onCreate
//
//setContent {
//    //mengubah warna 2 box dengan warna yang berbeda dari 1 box dengan state
//
//    Column(modifier = Modifier
//        .fillMaxSize()
//    )
//    {
//        val color = remember {
//            mutableStateOf(Color.Yellow)
//        }
//        StateColorBox(
//            Modifier
//                .weight(1f)
//                .fillMaxSize()
//        ){
//            color.value = it
//        }
////                warna box dibawah akan berubah ketika func StateColorBox dipanggil
//        Box(
//            modifier = Modifier
//                .background(color.value)
//                .weight(1f)
//                .fillMaxSize()
//
//        )
//    }
//}

@Composable
fun StateColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit
) {
    Box(
        modifier = modifier
            .background(Color.Red)
            .clickable {
                updateColor(
                    Color(
                        Random().nextInt(),
                        Random().nextInt(),
                        Random().nextInt()
                    )
                )
            }
    )
}