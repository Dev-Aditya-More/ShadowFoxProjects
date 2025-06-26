package com.aravind.composefitnessapp.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aravind.composefitnessapp.R
import com.aravind.composefitnessapp.ui.theme.Black
import com.aravind.composefitnessapp.ui.theme.GradientEnd
import com.aravind.composefitnessapp.ui.theme.GradientStart
import com.aravind.composefitnessapp.ui.theme.Grey1
import com.aravind.composefitnessapp.ui.theme.Grey2
import com.aravind.composefitnessapp.ui.theme.Grey3
import com.aravind.composefitnessapp.ui.theme.Pink1
import com.aravind.composefitnessapp.ui.theme.poppinsFamily

@Composable
fun ProfileScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        content = {
            item {
                Column(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 25.dp, bottom = 25.dp)
                        .wrapContentHeight()
                        .fillMaxWidth()

                ) {
                    val cardShape = RoundedCornerShape(16.dp)
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            "Profile",
                            color = Black,
                            fontSize = 20.sp,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(alignment = Alignment.Center)
                        )

                        Image(painter = painterResource(id = R.drawable.ic_options_menu),
                            contentDescription = null,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterEnd)
                                .background(color = Grey2, shape = RoundedCornerShape(8.dp))
                                .padding(start = 13.dp, end = 13.dp, top = 16.dp, bottom = 16.dp)
                                .clickable { println("Button Clicked!") })
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_profile_pic),
                            contentDescription = null,
                            modifier = Modifier
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .weight(1f)
                        ) {
                            Text(
                                "Aravindraj",
                                color = Black,
                                fontSize = 14.sp,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                "Lean & Tone program",
                                color = Grey1,
                                fontSize = 12.sp,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Normal
                            )
                        }
                        Button(

                            modifier = Modifier
                                .wrapContentSize()
                                .padding(start = 0.dp, end = 0.dp, bottom = 0.dp)
                                .background(
                                    brush = Brush.horizontalGradient(
                                        listOf(
                                            GradientStart, GradientEnd
                                        )
                                    ), shape = RoundedCornerShape(15.dp)
                                )
                                .height(32.dp),
                            onClick = { },
                            contentPadding = PaddingValues(start = 23.dp, end = 23.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                        ) {
                            Text(
                                "Edit",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Normal
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ) {


                        Card(


                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            modifier = Modifier
                                .weight(1f)
                                .shadow(
                                    shape = cardShape,
                                    spotColor = Grey3,
                                    elevation = 20.dp
                                ),
                            shape = cardShape
                        ) {


                            Column(

                                modifier = Modifier
                                    .padding(
                                        start = 20.dp,
                                        top = 12.dp,
                                        end = 20.dp,
                                        bottom = 12.dp
                                    )
                                    .fillMaxWidth(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    "180",
                                    fontSize = 14.sp,
                                    fontFamily = poppinsFamily,
                                    fontWeight = FontWeight.Medium,
                                    style = TextStyle(
                                        brush = Brush.horizontalGradient(
                                            listOf(
                                                GradientStart,
                                                GradientEnd
                                            )
                                        )
                                    )
                                )
                                Text(
                                    "Height",
                                    color = Grey1,
                                    fontSize = 12.sp,
                                    fontFamily = poppinsFamily,
                                    fontWeight = FontWeight.Normal,
                                    maxLines = 1
                                )
                            }

                        }
                        Spacer(modifier = Modifier.width(18.dp))
                        Card(
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            modifier = Modifier
                                .weight(1f)
                                .shadow(
                                    shape = cardShape,
                                    spotColor = Grey3,
                                    elevation = 20.dp
                                ),
                            shape = cardShape
                        ) {


                            Column(
                                modifier = Modifier
                                    .padding(
                                        start = 20.dp,
                                        top = 12.dp,
                                        end = 20.dp,
                                        bottom = 12.dp
                                    )
                                    .fillMaxWidth(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    "65",
                                    fontSize = 14.sp,
                                    fontFamily = poppinsFamily,
                                    fontWeight = FontWeight.Medium,
                                    style = TextStyle(
                                        brush = Brush.horizontalGradient(
                                            listOf(
                                                GradientStart,
                                                GradientEnd
                                            )
                                        )
                                    )
                                )
                                Text(
                                    "Weight",
                                    color = Grey1,
                                    fontSize = 12.sp,
                                    fontFamily = poppinsFamily,
                                    fontWeight = FontWeight.Normal,
                                    maxLines = 1
                                )
                            }

                        }
                        Spacer(modifier = Modifier.width(18.dp))
                        Card(
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            modifier = Modifier
                                .weight(1f)
                                .shadow(
                                    shape = cardShape,
                                    spotColor = Grey3,
                                    elevation = 20.dp
                                ),
                            shape = cardShape
                        ) {


                            Column(
                                modifier = Modifier
                                    .padding(
                                        start = 20.dp,
                                        top = 12.dp,
                                        end = 20.dp,
                                        bottom = 12.dp
                                    )
                                    .fillMaxWidth(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    "22yo",
                                    fontSize = 14.sp,
                                    fontFamily = poppinsFamily,
                                    fontWeight = FontWeight.Medium,
                                    style = TextStyle(
                                        brush = Brush.horizontalGradient(
                                            listOf(
                                                GradientStart,
                                                GradientEnd
                                            )
                                        )
                                    )
                                )
                                Text(
                                    "Age",
                                    color = Grey1,
                                    fontSize = 12.sp,
                                    fontFamily = poppinsFamily,
                                    fontWeight = FontWeight.Normal,
                                    maxLines = 1
                                )
                            }

                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        modifier = Modifier
                            .shadow(
                                shape = cardShape,
                                spotColor = Grey3,
                                elevation = 20.dp
                            ),
                        shape = cardShape
                    ) {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                "Account",
                                color = Black,
                                fontSize = 16.sp,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(
                                    start = 20.dp,
                                    end = 20.dp,
                                    top = 18.dp
                                )
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(
                                    start = 20.dp,
                                    end = 20.dp,
                                    top = 18.dp,
                                    bottom = 16.dp
                                )
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_leading_personal),
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(
                                    "Personal Data",
                                    color = Grey1,
                                    fontSize = 12.sp,
                                    fontFamily = poppinsFamily,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 12.dp)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.ic_arrow_right),
                                    contentDescription = null,
                                    modifier = Modifier
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(
                                    start = 20.dp,
                                    end = 20.dp,
                                    bottom = 16.dp
                                )
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_leading_achievement),
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(
                                    "Achievement",
                                    color = Grey1,
                                    fontSize = 12.sp,
                                    fontFamily = poppinsFamily,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 12.dp)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.ic_arrow_right),
                                    contentDescription = null,
                                    modifier = Modifier
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(
                                    start = 20.dp,
                                    end = 20.dp,
                                    bottom = 16.dp
                                )
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_leading_act_history),
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(
                                    "Activity History",
                                    color = Grey1,
                                    fontSize = 12.sp,
                                    fontFamily = poppinsFamily,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 12.dp)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.ic_arrow_right),
                                    contentDescription = null,
                                    modifier = Modifier
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(
                                    start = 20.dp,
                                    end = 20.dp,
                                    bottom = 16.dp
                                )
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_leading_work_progress),
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(
                                    "Workout Progress",
                                    color = Grey1,
                                    fontSize = 12.sp,
                                    fontFamily = poppinsFamily,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 12.dp)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.ic_arrow_right),
                                    contentDescription = null,
                                    modifier = Modifier
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        modifier = Modifier
                            .shadow(
                                shape = cardShape,
                                spotColor = Grey3,
                                elevation = 20.dp
                            ),
                        shape = cardShape
                    ) {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                "Notification",
                                color = Black,
                                fontSize = 16.sp,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(
                                    start = 20.dp,
                                    end = 20.dp,
                                    top = 18.dp
                                )
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(
                                    start = 20.dp,
                                    end = 20.dp,
                                    top = 18.dp,
                                    bottom = 16.dp
                                )
                            ) {
                                var checked by remember { mutableStateOf(false) }
                                Image(
                                    painter = painterResource(id = R.drawable.ic_leading_personal),
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(
                                    "Allow Notification",
                                    color = Grey1,
                                    fontSize = 12.sp,
                                    fontFamily = poppinsFamily,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 12.dp)
                                )
                                Switch(
                                    checked = checked,
                                    onCheckedChange = {
                                        checked = it
                                    },
                                    modifier = Modifier.scale(0.7f),
                                    colors = SwitchDefaults.colors(
                                        checkedThumbColor = Color.White,
                                        checkedTrackColor = Pink1,
                                        uncheckedBorderColor = Grey1,
                                        uncheckedThumbColor = Grey1,
                                        uncheckedTrackColor = Grey2
                                    )
                                )

                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        modifier = Modifier
                            .shadow(
                                shape = cardShape,
                                spotColor = Grey3,
                                elevation = 20.dp
                            ),
                        shape = cardShape
                    ) {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                "Other",
                                color = Black,
                                fontSize = 16.sp,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(
                                    start = 20.dp,
                                    end = 20.dp,
                                    top = 18.dp
                                )
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(
                                    start = 20.dp,
                                    end = 20.dp,
                                    top = 18.dp,
                                    bottom = 16.dp
                                )
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_leading_contact),
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(
                                    "Contact Us",
                                    color = Grey1,
                                    fontSize = 12.sp,
                                    fontFamily = poppinsFamily,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 12.dp)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.ic_arrow_right),
                                    contentDescription = null,
                                    modifier = Modifier
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(
                                    start = 20.dp,
                                    end = 20.dp,
                                    bottom = 16.dp
                                )
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_leading_privacy),
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(
                                    "Privacy Policy",
                                    color = Grey1,
                                    fontSize = 12.sp,
                                    fontFamily = poppinsFamily,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 12.dp)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.ic_arrow_right),
                                    contentDescription = null,
                                    modifier = Modifier
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(
                                    start = 20.dp,
                                    end = 20.dp,
                                    bottom = 16.dp
                                )
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_leading_settings),
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(
                                    "Settings",
                                    color = Grey1,
                                    fontSize = 12.sp,
                                    fontFamily = poppinsFamily,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 12.dp)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.ic_arrow_right),
                                    contentDescription = null,
                                    modifier = Modifier
                                )
                            }

                        }
                    }
                }
            }
        }
    )
}

@Composable
@Preview
fun ProfileScreenPreview() {
    ProfileScreen()
}