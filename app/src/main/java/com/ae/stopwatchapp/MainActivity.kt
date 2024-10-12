package com.ae.stopwatchapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ae.stopwatchapp.ui.theme.StopwatchTheme


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StopwatchTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val stopWatch = remember { StopWatch() }
                    StopWatchScreen(stopWatch = stopWatch)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StopwatchTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            val stopWatch = remember { StopWatch() }
            StopWatchScreen(stopWatch = stopWatch)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StopWatchScreen(stopWatch: StopWatch) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        StopWatchDisplay(
            formattedTime = stopWatch.formattedTime,
            onStartClick = stopWatch::start,
            onPauseClick = stopWatch::pause,
            onResetClick = stopWatch::reset,
            isPaused = stopWatch.isPaused // Pass isPaused state to StopWatchDisplay
        )
    }
}