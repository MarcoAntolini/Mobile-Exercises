package com.example.lab_01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab_01.ui.theme.Lab01Theme
import com.example.lab_01.ui.theme.Purple80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab01Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.size(
                        LocalConfiguration.current.screenWidthDp.dp / 2,
                        LocalConfiguration.current.screenHeightDp.dp,
                    ),
                    color = Purple80,
                ) {
//                    Greeting("Android")
//                    ChangeOrientation(LocalConfiguration.current)
//                    VerticalLayout(configuration = LocalConfiguration.current)
//                    HorizontalLayout(configuration = LocalConfiguration.current)
                    BoxConstraintsLayout()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab01Theme {
        Greeting("Android")
    }
}