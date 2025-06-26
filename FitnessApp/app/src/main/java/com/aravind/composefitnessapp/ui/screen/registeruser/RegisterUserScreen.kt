package com.aravind.composefitnessapp.ui.screen.registeruser

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aravind.composefitnessapp.R
import com.aravind.composefitnessapp.ui.theme.Black
import com.aravind.composefitnessapp.ui.theme.GradientEnd
import com.aravind.composefitnessapp.ui.theme.GradientStart
import com.aravind.composefitnessapp.ui.theme.Grey2
import com.aravind.composefitnessapp.ui.theme.Grey3
import com.aravind.composefitnessapp.ui.theme.Pink1
import com.aravind.composefitnessapp.ui.theme.poppinsFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterUserScreen(onRegisterSuccess: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().background(Color.White), verticalArrangement = Arrangement.SpaceBetween) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top = 20.dp, bottom = 20.dp)
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(
                    text = "Hey there,",
                    color = Black,
                    fontSize = 16.sp,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Create an Account",
                    color = Black,
                    fontSize = 20.sp,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(30.dp))

                var fullName by remember { mutableStateOf("") }

                TextField(
                    singleLine = true,
                    value = fullName,
                    onValueChange = { fullName = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    label = {
                        Text(
                            text = "Full Name",
                            color = Grey3,
                            fontSize = 12.sp,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Normal
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painterResource(R.drawable.ic_leading_full_name),
                            contentDescription = null
                        )
                    },
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Grey2,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                var phoneNumber by remember { mutableStateOf("") }
                TextField(
                    singleLine = true,
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    label = {
                        Text(
                            text = "Phone Number",
                            color = Grey3,
                            fontSize = 12.sp,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Normal
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painterResource(R.drawable.ic_leading_phone),
                            contentDescription = null
                        )
                    },
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Grey2,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                var email by remember { mutableStateOf("") }
                TextField(
                    singleLine = true,
                    value = email,
                    onValueChange = { email = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    label = {
                        Text(
                            text = "Email",
                            color = Grey3,
                            fontSize = 12.sp,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Normal
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painterResource(R.drawable.ic_leading_email),
                            contentDescription = null
                        )
                    },
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Grey2,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                var password by remember { mutableStateOf("") }
                TextField(
                    singleLine = true,
                    value = password,
                    onValueChange = { password = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    label = {
                        Text(
                            text = "Password",
                            color = Grey3,
                            fontSize = 12.sp,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Normal
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painterResource(R.drawable.ic_leading_password),
                            contentDescription = null
                        )
                    },
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Grey2,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    )
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            // in below line we are setting
            // the state of our checkbox.
            val checkedState = remember { mutableStateOf(false) }
            // in below line we are displaying a row
            // and we are creating a checkbox in a row.
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    // below line we are setting
                    // the state of checkbox.
                    checked = checkedState.value,
                    // below line is use to add on check
                    // change to our checkbox.
                    onCheckedChange = { checkedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Pink1,
                        uncheckedColor = Grey3,
                        checkmarkColor = Color.White
                    )
                )
                // below line is use to add text to our check box and we are
                // adding padding to our text of checkbox
                Text(
                    text = buildAnnotatedString {
                        append("By continuing you accept our ")
                        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                            append("Privacy Policy")
                        }
                        append(" and ")
                        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                            append("Terms of Use")
                        }
                    }, color = Grey3,
                    fontSize = 10.sp,
                    lineHeight = 13.sp,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal
                )

            }
        }

        Column(
            modifier = Modifier.padding(start = 25.dp, end = 25.dp, bottom = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp)

                    .background(
                        brush = Brush.horizontalGradient(listOf(GradientStart, GradientEnd)),
                        shape = ButtonDefaults.shape
                    )
                    .height(55.dp),
                onClick = { onRegisterSuccess()},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Text(
                    "Register", color = Color.White, fontSize = 16.sp,
                    fontFamily = poppinsFamily, fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Divider(
                    color = Grey3, modifier = Modifier
                        .height(1.dp)
                        .weight(0.45f)
                )
                Text(
                    "Or",
                    color = Black,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.weight(0.1f)
                )
                Divider(
                    color = Grey3, modifier = Modifier
                        .height(1.dp)
                        .weight(0.45f)
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.ic_signup_google),
                    contentDescription = "Signup Google",
                    modifier = Modifier
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = {


                            })
                        .size(50.dp)
                )
                Spacer(modifier = Modifier.width(30.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_signup_fb),
                    contentDescription = "Signup Google",
                    modifier = Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = {

                        })
                )
            }
            val loginString = "Login"
            val annotatedString = buildAnnotatedString {
                append("Already have an account? ")
                withStyle(
                    style = SpanStyle(
                        color = Pink1,
                        fontWeight = FontWeight.SemiBold
                    ),
                ) {
                    pushStringAnnotation(tag = loginString, annotation = loginString)
                    append(loginString)
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            ClickableText(text = annotatedString, style = TextStyle(
                color = Black,
                fontSize = 14.sp,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Normal
            ), onClick = { offset ->
                annotatedString.getStringAnnotations(offset, offset)
                    .firstOrNull()?.let { span ->
                        println("Clicked on ${span.item}")
                    }
            })

        }
    }
}


@Preview
@Composable
fun RegisterUserPreview() {
    RegisterUserScreen(onRegisterSuccess = {})
}