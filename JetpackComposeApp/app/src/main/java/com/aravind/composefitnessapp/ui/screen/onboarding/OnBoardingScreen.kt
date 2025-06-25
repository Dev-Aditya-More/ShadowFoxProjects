package com.aravind.composefitnessapp.ui.screen.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aravind.composefitnessapp.R
import com.aravind.composefitnessapp.ui.theme.Black
import com.aravind.composefitnessapp.ui.theme.Grey1
import com.aravind.composefitnessapp.ui.theme.poppinsFamily
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(onBoardingFinished: () -> Unit) {
    val onBoardingItemList = OnBoardingItem.getData()
    val scope = rememberCoroutineScope()
    val pageState = rememberPagerState {
        onBoardingItemList.size
    }
    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pageState,
            modifier = Modifier
                .fillMaxSize()
                .weight(0.8f)
        ) { page ->
            OnBoardingItem(item = onBoardingItemList[page])
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.2f)
                .padding(bottom = 30.dp, end = 25.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_next_button_rounded),
                contentDescription = "Next button",
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = {
                        if (pageState.currentPage + 1 < onBoardingItemList.size) scope.launch {
                            pageState.animateScrollToPage(pageState.currentPage + 1)
                        } else if (pageState.currentPage == 3) {
                            onBoardingFinished()
                        }
                    })
            )
        }
    }

}


@Composable
fun OnBoardingItem(item: OnBoardingItem) {
    Column(verticalArrangement = Arrangement.Top) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = stringResource(id = R.string.track_goal_content_desc),
            modifier = Modifier
                .fillMaxSize()
                .weight(0.7f),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 30.dp)
                .weight(0.3f)
        ) {
            Text(
                stringResource(id = item.title), color = Black, fontSize = 24.sp,
                fontFamily = poppinsFamily, fontWeight = FontWeight.Bold
            )
            Text(
                stringResource(id = item.desc),
                color = Grey1,
                fontSize = 14.sp,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Normal
            )
        }
    }
}
