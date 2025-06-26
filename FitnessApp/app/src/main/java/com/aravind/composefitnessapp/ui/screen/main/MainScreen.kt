package com.aravind.composefitnessapp.ui.screen.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aravind.composefitnessapp.ui.screen.BottomNavScreen
import com.aravind.composefitnessapp.ui.screen.activitytracker.ActivityTrackerScreen
import com.aravind.composefitnessapp.ui.screen.home.HomeScreen
import com.aravind.composefitnessapp.ui.screen.profile.ProfileScreen
import com.aravind.composefitnessapp.ui.screen.progressphoto.ProgressPhotoScreen
import com.aravind.composefitnessapp.ui.theme.NoRippleTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavScreen.Home,
        BottomNavScreen.ActivityTracker,
        BottomNavScreen.ProgressPhoto,
        BottomNavScreen.Profile
    )
    Scaffold(
        bottomBar = {
            CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
                NavigationBar(
containerColor = Color.White,
                    content = {

                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    items.forEach { screen ->
                        val selected =
                            currentDestination?.hierarchy?.any { it.route == screen.route } == true

                        NavigationBarItem(

                            icon = {
                                Icon(
                                    painterResource(id = if (selected) screen.iconSelected else screen.iconUnSelected),
                                    contentDescription = "",
                                    tint = Color.Unspecified,
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = White
                            ),
                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                            onClick = {
                                navController.navigate(screen.route) {
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    // on the back stack as users select items
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }
                            }
                        )
                    }
                })
            }
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = BottomNavScreen.Home.route,
            Modifier.padding(innerPadding)
        ) {
            composable(BottomNavScreen.Home.route) { HomeScreen() }
            composable(BottomNavScreen.ActivityTracker.route) { ActivityTrackerScreen() }
            composable(BottomNavScreen.ProgressPhoto.route) { ProgressPhotoScreen() }
            composable(BottomNavScreen.Profile.route) { ProfileScreen() }
        }
    }
}


@Composable
@Preview
fun MainScreenPreview() {
    MainScreen()
}
