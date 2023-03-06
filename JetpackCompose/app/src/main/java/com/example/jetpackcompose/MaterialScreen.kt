package com.example.jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldFunction(){
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Add, contentDescription = "Add item")
            }
        },
        bottomBar = {
            BottomAppBarFunction()
        }
    ) { contentPadding ->
        Column(Modifier.padding(contentPadding)) {
            ListScrollable()
        }
    }
}

@Composable
fun BottomAppBarFunction() {
    BottomAppBar {

        IconButton(onClick = { /* doSomething() */ }) {
            Icon(Icons.Filled.Menu, contentDescription = "Menu")
        }

        Spacer(Modifier.weight(1f, true))
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(Icons.Filled.ShoppingCart, contentDescription = "Shopping cart")
        }
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
        }
    }
}

@Composable
fun ListScrollable() {
    val listSize = 50

    LazyColumn(
        modifier = Modifier.padding(5.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp) // Gap between items
    ) {
        items(listSize) {
            //ListText(it)
            ListItemImage(it)
        }
    }
}

@Composable
fun ListItemImage(index: Int) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_android_black_24dp),
            contentDescription = "Android logo",
            modifier = Modifier.size(50.dp),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onSecondaryContainer)
        )

        Spacer(Modifier.width(10.dp))

        ListText(index)
    }
}


@Composable
fun ListText(index: Int) {
    Text(
        text = "Item n° $index",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSecondaryContainer
    )
}