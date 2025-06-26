package com.aravind.composefitnessapp.ui.screen.choosegoal

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aravind.composefitnessapp.R
import com.aravind.composefitnessapp.ui.theme.Black
import com.aravind.composefitnessapp.ui.theme.GradientEnd
import com.aravind.composefitnessapp.ui.theme.GradientStart
import com.aravind.composefitnessapp.ui.theme.Grey1
import com.aravind.composefitnessapp.ui.theme.poppinsFamily


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChooseGoalScreen(onGoalConfirmed: () -> Unit) {
    val chooseGoalModelList = ChooseGoalModel.getData()
    val scope = rememberCoroutineScope()
    val pageState = rememberPagerState {
        chooseGoalModelList.size
    }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(35.dp))
        Text(
            text = "What is your goal ?",
            color = Black,
            fontSize = 20.sp,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "It will help us to choose a best program for you",
            color = Black,
            fontSize = 12.sp,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(25.dp))
        HorizontalPager(
            state = pageState,
                    modifier = Modifier
                .weight(1f)
                .align(alignment = Alignment.Start)
                .padding(20.dp)
        ) { page ->
            GoalView(item = chooseGoalModelList[page])
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp, bottom = 25.dp)

                .background(
                    brush = Brush.horizontalGradient(listOf(GradientStart, GradientEnd)),
                    shape = ButtonDefaults.shape
                )
                .height(55.dp),
            onClick = { onGoalConfirmed() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Text(
                "Confirm", color = Color.White, fontSize = 16.sp,
                fontFamily = poppinsFamily, fontWeight = FontWeight.Bold
            )
        }
    }

}

@Composable
fun GoalView(item: ChooseGoalModel) {
    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top, modifier = Modifier
                .wrapContentSize()
                .background(
                    brush = Brush.horizontalGradient(listOf(GradientStart, GradientEnd)),
                    shape = RoundedCornerShape(40.dp),
                )
        ) {


            Spacer(modifier = Modifier.height(15.dp))
            Image(
                painter = painterResource(id = item.image),
                contentDescription = stringResource(id = R.string.track_goal_content_desc),
                modifier = Modifier
                    .height(300.dp).padding(10.dp),
                contentScale = ContentScale.Inside
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                stringResource(id = item.title), color = Color.White, fontSize = 14.sp,
                fontFamily = poppinsFamily, fontWeight = FontWeight.SemiBold
            )
            Text(
                stringResource(id = item.desc),
                color = Color.White,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}

@Composable
@Preview
fun ChooseGoalScreenPreview() {
    ChooseGoalScreen(onGoalConfirmed = {})
}
