package com.example.androidbreakfix

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogDemo(){

    var openDialog by remember{ mutableStateOf(false) }

    Column(

        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Button(onClick = {openDialog = true}) {

            Text("Click ME!")
        }

        if(openDialog){

            AlertDialog(
                onDismissRequest = {openDialog = false},
                confirmButton = {

                    TextButton(
                        onClick = {openDialog = false}
                    ) {
                        Text("Confirm")
                    }
                },

                dismissButton = {

                    TextButton(
                        onClick = { openDialog = false }
                    ) {
                        Text("Dismiss")
                    }
                },

                title = {
                    Text(text = "Dialog Title", style = MaterialTheme.typography.titleLarge)
                },
                text = {
                    Text("Here is the dialog content.", style = MaterialTheme.typography.bodyMedium)
                },
                properties = DialogProperties(dismissOnClickOutside = true)

            )
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun AlertDialogPreview(){

    AlertDialogDemo()
}