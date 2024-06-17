package com.example.promptopia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.promptopia.ui.theme.PromptopiaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PromptopiaTheme {
                EntryView()
            }
        }
    }
}

@Preview
@Composable
fun EntryView() {
    val imagePromptopia = painterResource(id = R.drawable.logotext)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        Color(255, 231, 223, 255),
                        Color(255, 231, 223, 255),
                        Color.White
                    )
                )
            )
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = imagePromptopia,
            contentDescription = "Logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(150.dp)
                .padding(bottom = 10.dp)
        )
        Box(modifier = Modifier.padding(bottom = 50.dp)) {
            Text(
                text = TextData.introText,
                color = Color(70, 70, 70, 205),
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        }


        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(235, 117, 80))
        ) {
            Text(text = "LOGIN", color = Color.White)
        }
        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(217, 217, 217))
        ) {
            Text(text = "SIGN UP", color = Color.Black)
        }
    }
}