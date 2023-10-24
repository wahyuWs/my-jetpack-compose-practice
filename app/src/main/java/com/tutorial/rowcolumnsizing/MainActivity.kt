package com.tutorial.rowcolumnsizing

import android.os.Bundle
import android.util.Size
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                useTextField()
            }
        }
    }

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

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun useTextField() {
        var text by remember { mutableStateOf(TextFieldValue("")) } //listener
        OutlinedTextField(
            value = text,
            onValueChange = {text = it},
            label = { Text("Number Phone") },
            placeholder = { Text("Input here") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
    }
}

/*
 * Column, membuat item menjadi vertical
 * Row, item menjadi horizontal
 * Modifier set :
 *              background(Color.Blue) - mengatur warna background column dan row
 *              fillMaxSize() - mengatur ukuran column ke max layar, default ukuran column menyesuaikan content
 *              fillMaxSize(0.5f) - mengatur ukuran column atau row menjadi width dan height menjadi 50%
 *              width(200.dp) - mengatur ukuran width menjadi 200dp
 *              height(200.dp) - mengatur ukuran height menjadi 200dp
 * horizontal dan vertical set :
 *              horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center - mengatur content center horizontal dan vertical
**/