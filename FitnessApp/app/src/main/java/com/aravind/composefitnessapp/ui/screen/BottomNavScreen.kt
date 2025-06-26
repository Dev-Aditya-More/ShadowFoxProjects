package com.aravind.composefitnessapp.ui.screen

import com.aravind.composefitnessapp.R

sealed class BottomNavScreen(var title:String, var iconSelected:Int, var iconUnSelected:Int,var route:String){

    object Home : BottomNavScreen("Home", R.drawable.ic_menu_home_selected, R.drawable.ic_menu_home,"home_screen")
    object ActivityTracker: BottomNavScreen("Activity",R.drawable.ic_menu_activity_selected,R.drawable.ic_menu_activity,"activity_tracker_screen")
    object ProgressPhoto: BottomNavScreen("Photo",R.drawable.ic_menu_photo_selected,R.drawable.ic_menu_photo,"progress_photo_screen")
    object Profile: BottomNavScreen("Profile",R.drawable.ic_menu_profile_selected,R.drawable.ic_menu_profile,"profile_screen")
}
