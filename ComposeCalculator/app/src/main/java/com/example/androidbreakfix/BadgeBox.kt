package com.example.androidbreakfix

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BadgeBoxDemo(){

    NavigationBar{
        NavigationBarItem(

            selected = false,
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth().wrapContentWidth(align = Alignment.Start),
            icon = {
                BadgedBox(badge = {
                    Badge{Text("8")}
                }) {

                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = null
                    )
                }
            },
            label = { Text("Favorites") }
        )
    }

}


@Preview(showSystemUi = true)
@Composable
fun BadgeBoxPreview(){

    BadgeBoxDemo()

}