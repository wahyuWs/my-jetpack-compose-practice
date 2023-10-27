package com.tutorial.rowcolumnsizing.ui.practice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.tutorial.rowcolumnsizing.R

val fontFamily = FontFamily(
    Font(R.font.rubik_black, FontWeight.Black),
    Font(R.font.rubik_blackitalic, FontWeight.Black),
    Font(R.font.rubik_bold, FontWeight.Bold),
    Font(R.font.rubik_bolditalic, FontWeight.Bold),
    Font(R.font.rubik_extrabold, FontWeight.ExtraBold),
    Font(R.font.rubik_extrabolditalic, FontWeight.ExtraBold),
    Font(R.font.rubik_italic, FontWeight.Thin),
    Font(R.font.rubik_light, FontWeight.Light),
    Font(R.font.rubik_lightitalic, FontWeight.Light),
    Font(R.font.rubik_medium, FontWeight.Medium),
    Font(R.font.rubik_mediumitalic, FontWeight.Medium),
    Font(R.font.rubik_regular, FontWeight.Normal),
    Font(R.font.rubik_semibold, FontWeight.SemiBold),
    Font(R.font.rubik_semibolditalic, FontWeight.SemiBold),
    )

@Composable
fun styling() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101010))
    ){
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        fontSize = 50.sp
                    )
                ){
                    append("J")
                }
                append("etpack ") //akan basic style yang dibawah
                withStyle(
                    style = SpanStyle(
                        color = Color.Green,
                        fontSize = 25.sp
                    )
                ){
                    append("Compose")
                }
            },
            //define basic style
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
        )
    }
}