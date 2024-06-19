package com.example.promptopia

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val data = intent.getBooleanExtra("login", true)
            DynamicLogSignView(data)
        }
    }
}

@Composable
fun DynamicLogSignView(isLoginOption: Boolean) {
    val backArrow = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24)
    val context = LocalContext.current
    if (isLoginOption) LoginView(backArrow, context) else SignUpView(backArrow, context)
}

@Composable
fun LoginView(backArrow: Painter, context: Context) {
    val userImage = painterResource(id = R.drawable.baseline_person_outline_24)
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        Color(255, 231, 223, 255),
                        Color(255, 231, 223, 255),
                        Color.White
                    )
                )
            )
            .padding(20.dp)
    ) {
        Box(modifier = Modifier.padding(bottom = 30.dp)) {
            Image(
                painter = backArrow,
                modifier = Modifier.clickable(true, onClick = {
                    onBackArrowClicked(context)
                }),
                contentDescription = "backArrow",
                contentScale = ContentScale.Fit
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = userImage,
                contentDescription = "UserImage",
                contentScale = ContentScale.Fit, modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(top = 10.dp)
            )
            Box(modifier = Modifier.padding(bottom = 20.dp)) {
                Text(text = TextData.loginText, fontSize = 35.sp)
            }
            TextField(
                value = email,
                onValueChange = { newText ->
                    email = newText
                },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                singleLine = true, colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White, unfocusedContainerColor = Color.White
                )
            )
            TextField(
                value = password,
                onValueChange = { newText ->
                    password = newText
                },
                label = { Text("Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                singleLine = true, colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White, unfocusedContainerColor = Color.White
                )
            )
            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(235, 117, 80))
            ) {
                Text(text = "LOGIN", color = Color.White)
            }
        }

    }
}


@Composable
fun SignUpView(backArrow: Painter, context: Context) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var userName by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        Color(255, 231, 223, 255),
                        Color(255, 231, 223, 255),
                        Color.White
                    )
                )
            )
            .padding(20.dp)
    ) {
        Box(modifier = Modifier.padding(bottom = 30.dp)) {
            Image(
                painter = backArrow,
                contentDescription = "backArrow",
                contentScale = ContentScale.Fit,
                modifier = Modifier.clickable(true, onClick = { onBackArrowClicked(context) })
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(modifier = Modifier.padding(bottom = 20.dp)) {
                Text(text = TextData.signUPText, fontSize = 35.sp)
            }
            TextField(
                value = email,
                onValueChange = { newText ->
                    email = newText
                },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                singleLine = true, colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White, unfocusedContainerColor = Color.White
                )
            )
            TextField(
                value = password,
                onValueChange = { newText ->
                    password = newText
                },
                label = { Text("Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                singleLine = true, colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White, unfocusedContainerColor = Color.White
                )
            )
            TextField(
                value = userName,
                onValueChange = { newText ->
                    userName = newText
                },
                label = { Text("UserName") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                singleLine = true, colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White, unfocusedContainerColor = Color.White
                )
            )
            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(217, 217, 217))
            ) {
                Text(text = TextData.signUPText, color = Color.Black)
            }
        }
    }
}


fun onBackArrowClicked(context: Context) {
    val intent = Intent(context, MainActivity::class.java)
    context.startActivity(intent)
}