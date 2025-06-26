package com.example.androidbreakfix

sealed class CalcOperations(val symbol: String) {

    object Add: CalcOperations("+")
    object Subtract: CalcOperations("-")
    object Multiply: CalcOperations("x")
    object Divide: CalcOperations("/")

    companion object {
        fun fromSymbol(symbol: String): CalcOperations? {
            return when (symbol) {
                "+" -> Add
                "-" -> Subtract
                "x" -> Multiply
                "/" -> Divide
                else -> null
            }
        }
    }
}
