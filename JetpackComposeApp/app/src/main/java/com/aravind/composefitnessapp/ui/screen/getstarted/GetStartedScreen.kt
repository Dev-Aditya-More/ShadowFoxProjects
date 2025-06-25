package com.aravind.composefitnessapp.ui.screen.getstarted

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aravind.composefitnessapp.ui.theme.Black
import com.aravind.composefitnessapp.ui.theme.GradientEnd
import com.aravind.composefitnessapp.ui.theme.GradientStart
import com.aravind.composefitnessapp.ui.theme.Grey1
import com.aravind.composefitnessapp.ui.theme.poppinsFamily


@OptIn(ExperimentalTextApi::class)
@Composable
fun GetStartedScreen(onGetStarted: () -> Unit) {
    Box {


        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp)
                .fillMaxSize()
        ) {


            Text(buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 36.sp,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Bold,
                        brush = Brush.horizontalGradient(listOf(GradientStart, GradientEnd))
                    ),
                ) {
                    append("FITNESS")
                }
                withStyle(
                    style = SpanStyle(
                        color = Black, fontSize = 34.sp,
                        fontFamily = poppinsFamily, fontWeight = FontWeight.Normal
                    )
                ) {
                    append("APP")
                }
            })

            Text(
                "Everybody Can Train",
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                color = Grey1
            )


        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(start = 55.dp, end = 55.dp, bottom = 65.dp)

                .background(
                    brush = Brush.horizontalGradient(listOf(GradientStart, GradientEnd)),
                    shape = ButtonDefaults.shape
                )
                .height(55.dp),
            onClick = onGetStarted,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Text(
                "Get Started", color = Color.White, fontSize = 16.sp,
                fontFamily = poppinsFamily, fontWeight = FontWeight.Bold
            )
        }
    }
}