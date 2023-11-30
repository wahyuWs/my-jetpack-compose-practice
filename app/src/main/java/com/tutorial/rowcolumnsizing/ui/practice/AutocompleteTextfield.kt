package com.tutorial.rowcolumnsizing.ui.practice

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextFieldSuggettion() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        AutoCompleteText(
            day = listOf(
                "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu"
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoCompleteText(day: List<String>) {
    var category by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(14.dp)
    ) {
        Text(
            text = "Favorite Day",
            fontSize = 16.sp,
            color = Color.Black,
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = category,
            onValueChange = {
                category = it
                expanded = true
            },
            placeholder = { Text("Enter your day") },
            trailingIcon = {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = "arrow",
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        )
        AnimatedVisibility(visible = expanded) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .background(Color.Gray),
                shape = RoundedCornerShape(18.dp)
            ) {
                LazyColumn {
                    if (category.isNotEmpty()) {
                        items(
                            //filter suggestions based on textfields
                            day.filter {
                                it.lowercase()
                                    .contains(category.lowercase())
                            }
                                .sorted()
                        ) {
                            ItemSuggetion(title = it) {
                                category = it
                                expanded = false
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ItemSuggetion(
    title: String,
    onclick: (String) -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp, start = 10.dp, end = 10.dp)
        .clickable {
            onclick(title)
        }
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}