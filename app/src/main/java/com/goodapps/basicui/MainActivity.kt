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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.goodapps.basicui.ui.theme.BasicUITheme

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
                        GetAllPosts()
                    }
                }
            }
        }
    }

    @Composable
    fun GetAllPosts(){
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            GetPost()
            Spacer(modifier = Modifier.size(8.dp))
            GetPost()
            Spacer(modifier = Modifier.size(8.dp))
            GetPost()
            Spacer(modifier = Modifier.size(8.dp))
            GetPost()
            Spacer(modifier = Modifier.size(8.dp))
            GetPost()
        }
    }
    @Composable
    fun GetPost(){
        Column(
            modifier = Modifier
                .padding(all = 8.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(R.drawable.icon),
                    contentDescription = "صورة"
                )
                Column(
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(
                        text = "Tamer Mahmoudِ",
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue
                    )
                    Spacer(modifier = Modifier.size(5.dp))
                    Text(text = "5m")
                }
            }
            Spacer(modifier = Modifier.size(8.dp))
            Image(
                modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth(),
                painter = painterResource(R.drawable.main_image),
                contentDescription = "",
                contentScale = ContentScale.Inside
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ScreenPreview(){
        GetAllPosts()
    }
}

