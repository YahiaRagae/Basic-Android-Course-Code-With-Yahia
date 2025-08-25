package com.goodapps.basicui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.goodapps.basicui.ui.theme.BasicUITheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicUITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(paddingValues = innerPadding)
                            .fillMaxSize()
                    ) {
                        GetContent()
                    }
                }
            }
        }
    }

    @Composable
    fun GetContent(){
        Column (
            modifier = Modifier.padding(8.dp)
        ){
            var number1 by remember { mutableStateOf("") }
            var number2 by remember { mutableStateOf("") }
            var sum by remember { mutableStateOf("") }

            TextField(
                value = number1,
                onValueChange = { newValue->
                    number1 = newValue
                },
                placeholder = {
                    Text("Enter first number")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.size(8.dp))
            TextField(
                value = number2,
                onValueChange = { newValue->
                    number2 = newValue
                },
                placeholder = {
                    Text("Enter second number")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = sum,
                modifier = Modifier.padding(8.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            HorizontalDivider()
            Row {
                Button(
                    modifier = Modifier.weight(1F),
                    onClick = {
                    val number1Int = number1.toInt()
                    val number2Int = number2.toInt()

                    sum = (number1Int + number2Int).toString()
                }) {
                    Text("Sum")
                }
                Spacer(modifier = Modifier.size(10.dp))
                Button(
                    modifier = Modifier.weight(1F),
                    onClick = {
                    number1 = ""
                    number2 = ""
                    sum = ""
                }) {
                    Text("Clear")
                }
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun ScreenPreview(){
        GetContent()
    }
}

