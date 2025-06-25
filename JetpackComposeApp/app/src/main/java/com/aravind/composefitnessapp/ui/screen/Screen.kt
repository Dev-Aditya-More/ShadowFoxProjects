package com.aravind.composefitnessapp.ui.screen

sealed class Screen(val route: String){
    object GetStarted : Screen("getStarted")
    object OnBoarding : Screen("onBoarding")
    object RegisterUser : Screen("registerUser")
    object CompleteProfile : Screen("completeProfile")
    object ChooseGoal : Screen("chooseGoal")

    object Main : Screen("main")

    
}
