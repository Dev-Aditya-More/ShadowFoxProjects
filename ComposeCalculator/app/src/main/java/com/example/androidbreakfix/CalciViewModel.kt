package com.example.androidbreakfix

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CalciViewModel : ViewModel(){

    var state by mutableStateOf(CalciState())
        private set


    fun onAction(action: CalcuActions){

        when(action){
            is CalcuActions.Number -> enterNumber(action.number)
            is CalcuActions.Decimal -> enterDecimal()
            is CalcuActions.Clear -> state = CalciState()
            is CalcuActions.Operation -> enterOperation(action.operation)
            is CalcuActions.Calculate -> performCalculation()
            is CalcuActions.Delete -> performDeletion()
        }
    }

    fun loadStateFrom(context: Context) {
        viewModelScope.launch {
            state = CalciStateManager.loadState(context)
        }
    }

    fun saveStateTo(context: Context) {
        viewModelScope.launch {
            CalciStateManager.saveState(context, state)
        }
    }


    private fun performDeletion() {

        when{

            state.number2.isNotBlank() -> state = state.copy(

                number2 = state.number2.dropLast(1)
            )

            state.operation != null -> state = state.copy(
                operation = null
            )

            state.number1.isNotBlank() -> state = state.copy(

                number1 = state.number1.dropLast(1)
            )
        }
    }

    fun performCalculation() {

        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()

        if(number1 != null && number2 != null){

            val result = when(state.operation){
                is CalcOperations.Add -> number1 + number2
                is CalcOperations.Subtract -> number1 - number2
                is CalcOperations.Multiply -> number1 * number2
                is CalcOperations.Divide -> {
                    if (number2 == 0.0) {

                        state = state.copy(error = "It's Undefined, mf")
                        return
                    }
                    number1 / number2
                }

                null -> return
            }


            state = state.copy(
                number1 = result.toString().take(8),
                number2 = "",
                operation = null
            )

        }
    }


    private fun enterOperation(operations: CalcOperations) {

        if(state.number1.isNotBlank()){

            state = state.copy(operation = operations, error = null)

        }
    }

    private fun enterDecimal() {

        if (state.operation == null) {
            if (!state.number1.contains(".")) {
                state = state.copy(
                    number1 = if (state.number1.isBlank()) "0." else state.number1 + "."
                )
            }
        }else{

            if(!state.number2.contains(".")){

                state = state.copy(
                    number2 = if(state.number2.isBlank()) "0." else state.number2 + ".", error = null
                )
            }
        }

    }

    private fun enterNumber(n: Int) {

        if (state.operation == null) {
            if (state.number1.length >= MAX_NUM_LENGTH) return
            state = state.copy(
                number1 = state.number1 + n,
                error = null
            )
        } else {
            if (state.number2.length >= MAX_NUM_LENGTH) return
            state = state.copy(
                number2 = state.number2 + n,
                error = null
            )
        }

    }
    companion object{

        private const val MAX_NUM_LENGTH = 8
    }
}

