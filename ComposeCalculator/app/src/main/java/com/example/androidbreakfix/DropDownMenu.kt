package com.example.androidbreakfix

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DropDownDemo(){

    var expanded by remember { mutableStateOf(false) }
    var items = listOf("A", "B", "C", "D", "E")
    val disabledValue = "B"
    var selectedIndex by remember { mutableIntStateOf(0) }
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.TopStart)

    ) {

        Text(
            text = items[selectedIndex], modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer)
                .clickable{expanded = true}
                .padding(12.dp),
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(MaterialTheme.colorScheme.surface)
        ) {
            items.forEachIndexed { index, item ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = if (item == disabledValue) "$item (Disabled)" else item,
                            color = if (item == disabledValue) Color.Gray else Color.Unspecified
                        )
                    },
                    onClick = {
                        if (item != disabledValue) {
                            selectedIndex = index
                            expanded = false
                        }
                    },
                    enabled = item != disabledValue
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DropDownPreview(){

    DropDownDemo()

}