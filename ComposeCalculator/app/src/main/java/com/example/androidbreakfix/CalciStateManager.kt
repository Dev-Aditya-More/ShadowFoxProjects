@file:Suppress("EXTENSION_SHADOWED_BY_MEMBER")

package com.example.androidbreakfix

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

val Context.calculatorDataStore by preferencesDataStore(name = "calculator_prefs")
object CalciStateManager {

    private val KEY_NUMBER1 = stringPreferencesKey("number1")
    private val KEY_NUMBER2 = stringPreferencesKey("number2")
    private val KEY_OPERATION = stringPreferencesKey("operation")

    suspend fun saveState(context: Context, state: CalciState) {
        context.calculatorDataStore.edit { prefs ->
            prefs[KEY_NUMBER1] = state.number1
            prefs[KEY_NUMBER2] = state.number2
            prefs[KEY_OPERATION] = state.operation?.symbol ?: ""
        }
    }

    suspend fun loadState(context: Context): CalciState {
        val prefs = context.calculatorDataStore.data.first()
        val opSymbol = prefs[KEY_OPERATION] ?: ""
        return CalciState(
            number1 = prefs[KEY_NUMBER1] ?: "",
            number2 = prefs[KEY_NUMBER2] ?: "",
            operation = CalcOperations.fromSymbol(opSymbol)
        )
    }

    fun CalcOperations.Companion.fromSymbol(symbol: String): CalcOperations? {
        return when (symbol) {
            "+" -> CalcOperations.Add
            "-" -> CalcOperations.Subtract
            "x" -> CalcOperations.Multiply
            "/" -> CalcOperations.Divide
            else -> null
        }
    }

}
