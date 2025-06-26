package com.example.androidbreakfix

sealed class CalcuActions {

    data class Number(val number: Int) : CalcuActions()
    object Clear: CalcuActions()
    object Delete: CalcuActions()
    object Decimal: CalcuActions()
    object Calculate: CalcuActions()
    data class Operation(val operation: CalcOperations): CalcuActions()
}