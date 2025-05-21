package com.example.baituan2_btvn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.compose.material3.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme{
                YearCheck()
            }
                }
            }
        }


@Composable
fun YearCheck(){
    var username by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    var yearcheck by remember { mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
        ){
        Text(
            text = "Bài tập về nhà tuần 2",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier =  Modifier.height(24.dp))
            OutlinedTextField(
                value = username,
                onValueChange = {
                    username = it
                },
                label = { Text("Họ và Tên") },
                modifier = Modifier.fillMaxWidth(0.8f)

            )
            OutlinedTextField(
                value = year,
                onValueChange = {
                    year = it
                },
                label = { Text("Nhập tuổi") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )


            Button(
                onClick = {
                    val yearInt = year.toIntOrNull()
                yearcheck = when {
                    yearInt == null -> " Tuổi không hợp lệ"
                    yearInt > 65 -> "$username ($year tuổi ) :Người già"
                    yearInt in 6..65 ->"$username ($year tuổi) :Người lớn"
                    yearInt in 2..6 ->"$username ($year tuổi) :Trẻ em"
                    yearInt < 2 ->"$username ($year tuổi) :Em bé"
                    else -> "Tuôi không xác định"

                }
                }
            ) { Text("Kiểm tra") }
            if (yearcheck.isNotEmpty()){
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = yearcheck,
                    color = Color.Green,
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun Yearcheckpreview(){
    MaterialTheme{
        YearCheck()
    }
}



