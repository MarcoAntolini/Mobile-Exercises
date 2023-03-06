package com.example.traveldiary

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(){
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Add, contentDescription = stringResource(id = R.string.add_travel))
            }
        },
        topBar = {
            TopAppBarFunction(stringResource(id = R.string.add_travel))
        }
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(paddingValues)
                .padding(10.dp)
                .fillMaxSize()
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ) {
                var title by rememberSaveable { mutableStateOf("") }

                OutlinedTextField(
                    value = title,
                    onValueChange = { newText ->
                        title = newText
                    },
                    label = {
                        Text(stringResource(id = R.string.place_title))
                    },
                    modifier = Modifier.weight(4f)
                )

                Icon(
                    painter = painterResource(id = R.drawable.baseline_gps_fixed_24),
                    contentDescription = "get gps",
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.size(15.dp))
            
            var travelDate by rememberSaveable { mutableStateOf("") }
            OutlinedTextField(
                value = travelDate,
                onValueChange = { travelDate = it },
                label = { Text(stringResource(id = R.string.place_date)) },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.size(15.dp))

            var travelDescription by rememberSaveable { mutableStateOf("") }
            OutlinedTextField(
                value = travelDescription,
                onValueChange = { travelDescription = it },
                label = { Text(stringResource(id = R.string.place_description)) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.size(15.dp))

            Button(
                onClick = { /* Do something! */ },
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
            ) {
                Icon(
                    Icons.Filled.PhotoCamera,
                    contentDescription = "Camera icon",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Take a picture")
            }

            Spacer(modifier = Modifier.size(15.dp))

            Image(
                painter = painterResource(id = R.drawable.baseline_android_24),
                contentDescription = "image taken",
                modifier = Modifier.fillMaxWidth().height(150.dp),
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onSecondaryContainer)
            )

        }
    }
}