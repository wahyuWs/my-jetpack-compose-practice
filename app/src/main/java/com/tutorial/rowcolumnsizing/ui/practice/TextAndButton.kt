package com.tutorial.rowcolumnsizing.ui.practice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun text1() {
    Column(
        modifier = Modifier
            .background(Color.Blue)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly//jarak vertical
    ) {
        Text("Kotlin")
        Text("Asik")
    }
}

@Composable
fun textAndButton() {
    //create text and button
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Hello Kamu Sangat Pintar Sekali",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                color = Color.Green
            ),
            modifier = Modifier
                .padding(bottom = 20.dp) //outer padding(margin)
                .background(Color.Gray)
                .padding(14.dp) //inner padding
        )
        Button(onClick = { /*TODO*/ },
            shape =  RoundedCornerShape(14.dp),
        ) {
            Text(text = "Oke")
        }
    }
}