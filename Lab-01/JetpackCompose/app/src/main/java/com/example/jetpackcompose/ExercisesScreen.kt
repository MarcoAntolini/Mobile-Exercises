package com.example.jetpackcompose

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.Purple40
import com.example.jetpackcompose.ui.theme.Purple80

//3. Cambio di configurazione
@Composable
fun OrientationChange(configuration: Configuration) {
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            Greeting(name = "Landscape")
        }
        else -> {
            Greeting(name = "Portrait")
        }
    }
}

//4.1 Layout - Column
@Composable
fun VerticalLayout(configuration: Configuration) {
    Column {
        Greeting(name = "Android")
        OrientationChange(configuration = configuration)
    }
}

//4.2 Layout - Row
@Composable
fun HorizontalLayout(configuration: Configuration) {
    Row {
        Greeting(name = "Android")
        OrientationChange(configuration = configuration)
    }
}

//4.3 Layout - Box
@Composable
fun BoxLayout(configuration: Configuration) {
    Box {
        Greeting(name = "Android")
        OrientationChange(configuration = configuration)
    }
}

//4.4 Layout - BoxWithConstraints
@Composable
fun BoxWithConstraintsLayout() {
    BoxWithConstraints () {
        //lo scope permette di ottenere le dimensioni del box
        val boxWithConstraintsScope = this

        Column {
            if (boxWithConstraintsScope.maxHeight >= 400.dp) {
                Greeting(">= 400.dp")
            }

            Spacer(modifier = Modifier.size(10.dp))

            Text("minHeight: ${boxWithConstraintsScope.minHeight}, \n" +
                    "maxHeight: ${boxWithConstraintsScope.maxHeight}, \n" +
                    "minWidth: ${boxWithConstraintsScope.minWidth} \n" +
                    "maxWidth: ${boxWithConstraintsScope.maxWidth}")
        }
    }
}

//5. Contenuto dinamico
@Composable
fun Greeting(names: List<String>) {
    for (name in names) {
        Text(text = "Hello $name!")
    }
}

//6. Lista scrollabile
@Composable
fun ScrollingList() {
    val listSize = 50

    Column(
        Modifier.padding(16.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp) // Gap between items
        ) {
            items(listSize) {
                ListItem(it)
            }
        }
    }
}

@Composable
fun ListItem(index: Int) {
    Text(
        text = "Item n° $index",
        style = MaterialTheme.typography.bodyLarge,
        color = if (isSystemInDarkTheme()) Purple80 else Purple40
    )
}