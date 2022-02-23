package com.example.ticktacktock

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.ticktacktock.destinations.HomeScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun SplashScreen(navigator: DestinationsNavigator) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFf6f9f8)), contentAlignment = Alignment.Center
    ) {
        /** Lotti file location specified */
        val composition =
            rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lotti))

        /** Add extra properties to lottie file object*/
        val progress = animateLottieCompositionAsState(composition.value, speed = 2.0f)
        /** Lotti File Animation*/
        LottieAnimation(
            composition.value,
            progress.value
        )

        /** Navigate to next screen after lotti file complete*/
        if (progress.progress == 1.0f) {
            LaunchedEffect(key1 = true) {
                navigator.popBackStack()
                navigator.navigate(HomeScreenDestination())
            }
        }
    }
}