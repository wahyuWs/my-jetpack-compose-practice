package com.tutorial.rowcolumnsizing.ui.practice

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue

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