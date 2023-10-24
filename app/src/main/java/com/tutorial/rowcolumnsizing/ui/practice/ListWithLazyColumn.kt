package com.tutorial.rowcolumnsizing.ui.practice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tutorial.rowcolumnsizing.Person
import com.tutorial.rowcolumnsizing.R

val data = listOf("Senin","Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu")
val dataPerson = ArrayList<Person>()

@Composable
fun simpleList() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ){
        items(data) { value ->
            Text(text = "Ini hari $value", color = Color.Black)
        }
    }
}

@Composable
fun listRowCustom(person: Person) {
    Row(
        modifier = Modifier
            .padding(bottom = 4.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.Gray),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(id = person.image),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(80.dp)
        )
        Text(text = person.text, color = Color.White)
    }
}

fun addDataPerson() {
    dataPerson.add(Person(R.drawable.steve_jobs, "text1"))
    dataPerson.add(Person(R.drawable.steve_jobs, "text2"))
    dataPerson.add(Person(R.drawable.steve_jobs, "text3"))
    dataPerson.add(Person(R.drawable.steve_jobs, "text4"))
}

@Composable
fun customList() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(dataPerson) {item ->
            listRowCustom(person = item)
        }
    }
}