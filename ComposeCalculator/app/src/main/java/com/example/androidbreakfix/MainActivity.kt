package com.example.androidbreakfix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.androidbreakfix.ui.theme.AndroidBreakFixTheme
import com.example.androidbreakfix.ui.theme.MediumGray
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBreakFixTheme {

                val viewModel: CalciViewModel = viewModel()
                val context = LocalContext.current
                val state = viewModel.state
                val buttonSpacing = 8.dp

                // Load state once
                LaunchedEffect(Unit) {
                    viewModel.loadStateFrom(context)
                }

                // Save on every state change
                LaunchedEffect(state) {
                    viewModel.saveStateTo(context)
                }

                Calculator(
                    state = state,
                    buttonSpacing = buttonSpacing,
                    onAction = viewModel::onAction,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MediumGray)
                        .padding(16.dp)
                        .navigationBarsPadding()
                )
            }
        }
    }
}


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ScaffoldExample(){
//
//    val snackbarHostState = remember { SnackbarHostState() }
//    val scope = rememberCoroutineScope()
//
//    Scaffold(
//
//        topBar = {
//            TopAppBar(
//                title = {Text("My App")},
//                colors = TopAppBarColors(
//                    containerColor = Color.LightGray,
//                    titleContentColor = Color.Black,
//                    navigationIconContentColor = Color.White,
//                    actionIconContentColor = Color.White,
//                    scrolledContainerColor = Color.Transparent
//                )
//            )
//        },
//
//        bottomBar = {
//
//            BottomAppBar{
//                Text("Bottom bar", modifier = Modifier.padding(16.dp))
//            }
//        },
//        floatingActionButton = {
//
//            FloatingActionButton(
//                onClick = {
//                    scope.launch {
//                        snackbarHostState.showSnackbar("Hello")
//                    }
//                }
//            ) {
//                Icon(Icons.Default.Add, contentDescription = "Add")
//            }
//        },
//
//        snackbarHost = {
//            SnackbarHost(hostState = snackbarHostState)
//        }
//    ) {innerPadding ->
//
//        Column(
//            modifier = Modifier
//                .padding(innerPadding)
//                .fillMaxSize()
//                .padding(16.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text("Welcome to the Scaffold layout!")
//        }
//
//    }
//
//}
//
//
//
//@Preview(showSystemUi = true)
//@Composable
//fun ScaffoldPreview() {
//    AndroidBreakFixTheme {
//        ScaffoldExample()
//    }
//}
