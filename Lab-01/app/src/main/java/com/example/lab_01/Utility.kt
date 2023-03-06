package com.example.lab_01

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChangeOrientation(configuration: Configuration) {
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            Greeting(name = "Landscape")
        }
        else -> {
            Greeting(name = "Portrait")
        }
    }
}

@Composable
fun VerticalLayout(configuration: Configuration) {
    Column {
        Greeting(name = "Android")
        ChangeOrientation(configuration = configuration)
    }
}

@Composable
fun HorizontalLayout(configuration: Configuration) {
    Row {
        Greeting(name = "Android")
        ChangeOrientation(configuration = configuration)
    }
}

@Composable
fun BoxConstraintsLayout() {
    BoxWithConstraints {
        val scope = this
        Column {
            if (scope.maxHeight >= 400.dp) {
                Greeting(name = ">= 400dp")
            }
            Spacer(modifier = Modifier.size(16.dp))
            Text(text =
                "minHeight = ${scope.minHeight} \n" + "maxHeight = ${scope.maxHeight} \n" +
                "minWidth = ${scope.minWidth} \n" + "maxWidth = ${scope.maxWidth}"
            )
        }
    }
}