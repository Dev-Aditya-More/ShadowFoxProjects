package com.example.androidbreakfix

data class CalciState(

    val number1: String = "",
    val number2: String = "",
    val operation: CalcOperations? = null,
    val error: String? = null
)