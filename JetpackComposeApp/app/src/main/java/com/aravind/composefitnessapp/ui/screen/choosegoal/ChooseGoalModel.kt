package com.aravind.composefitnessapp.ui.screen.choosegoal

import com.aravind.composefitnessapp.R

class ChooseGoalModel(
    val image: Int,
    val title: Int,
    val desc: Int
) {
    companion object{
        fun getData(): List<ChooseGoalModel>{
            return listOf(
                ChooseGoalModel(R.drawable.ic_improve_shape, R.string.improve_shape_title, R.string.improve_shape_desc),
                ChooseGoalModel(R.drawable.ic_lean_tone, R.string.lean_tone_title, R.string.lean_tone_desc),
                ChooseGoalModel(R.drawable.ic_loose_fat, R.string.loose_fat_title, R.string.loose_fat_desc)
            )
        }
    }
}