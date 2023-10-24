package com.tutorial.rowcolumnsizing.ui.practice

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

//not finished

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun showBottomNavigation() {
//    val selectedItem = remember { mutableStateOf(0) }
//    Scaffold (
//        bottomBar = {
//            BottomNavigation {
//                BottomNavigationItem(
//                    icon = {Icon(Icons.Default.Home)},
//                    label = { Text("Home") },
//                    selected = (selectedItem.value == 0),
//                    onclick = {selectedItem.value = 0}
//
//                )
//
//                BottomNavigationItem(
//                    icon = {Icon(Icons.Default.Favorite)},
//                    label = { Text("Favorite") },
//                    selected = (selectedItem.value == 1),
//                    onclick = {selectedItem.value = 1}
//
//                )
//            }
//        }
//    )
//}