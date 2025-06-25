package com.aravind.composefitnessapp.ui.screen.onboarding

import com.aravind.composefitnessapp.R

class OnBoardingItem(
    val image: Int,
    val title: Int,
    val desc: Int
) {
    companion object{
        fun getData(): List<OnBoardingItem>{
            return listOf(
                OnBoardingItem(R.drawable.ic_track_goal, R.string.track_goal_title, R.string.track_goal_desc),
                OnBoardingItem(R.drawable.ic_get_burn, R.string.get_burn_title, R.string.get_burn_desc),
                OnBoardingItem(R.drawable.ic_eat_well, R.string.eat_well_title, R.string.eat_well_desc),
                OnBoardingItem(R.drawable.ic_improve_sleep, R.string.improve_sleep_title, R.string.improve_sleep_desc)
            )
        }
    }
}