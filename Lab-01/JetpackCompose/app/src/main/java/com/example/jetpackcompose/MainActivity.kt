package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import com.example.jetpackcompose.ui.theme.Purple80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // LocalConfiguration.current è richiamabile solo dentro una funzione compasable
                val configuration = LocalConfiguration.current
                // A surface container using the 'background' color from the theme
                Surface(
                    //2. Modifier
                    /*modifier = Modifier.size(
                        configuration.screenWidthDp.dp/2,
                        configuration.screenHeightDp.dp
                    ),*/
                    modifier = Modifier.fillMaxSize(),
                    //1. Scaffold (color)
                    color = Purple80
                ) {
                    Column {

                        //Greeting("Android")

                        //3. Cambio di configurazione
                        //OrientationChange(configuration)

                        //4.1 Layout (Column)
                        //VerticalLayout(configuration)

                        //4.2 Layout (Row)
                        //HorizontalLayout(configuration)

                        //4.3 Layout (Box)
                        //BoxLayout(configuration)

                        //4.4 Layout (BoxWithConstraints)
                        //BoxWithConstraintsLayout()

                        //4.4 Layout (BoxWithConstraints -domanda)
                        /*Column(modifier = Modifier.height(150.dp)) {
                            BoxWithConstraintsLayout()
                        }*/

                        //5. Contenuto dinamico
                        /*val names : List<String> = listOf("Android","A","N","D")
                        val names : List<String> = listOf<String>("Android","A","N","D")
                        val names = listOf<String>("Android","A","N","D")
                        val names = listOf("Android","A","N","D")
                        Greeting(names)*/

                        //6. Lista Scrollabile
                        //ScrollingList()

                        //7. Utilizzare Material
                        ScaffoldFunction()
                    }

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
    JetpackComposeTheme {
        Greeting("Android")
    }
}