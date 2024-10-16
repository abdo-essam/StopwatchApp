package com.ae.stopwatchapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

class StopWatch {

    var formattedTime by mutableStateOf("00:00:000")
    private var coroutineScope = CoroutineScope(Dispatchers.Default)
    private var isActive = false

    private var timeMillis = 0L
    private var lastTimeStamp = 0L

    var isPaused by mutableStateOf(false) // New state to track pause

    @RequiresApi(Build.VERSION_CODES.O)
    fun start() {
        if (isActive)
            return

        isPaused = false // Reset isPaused when starting/resuming

        coroutineScope.launch {
            lastTimeStamp = System.currentTimeMillis()
            this@StopWatch.isActive = true
            while (this@StopWatch.isActive) {
                delay(10L)
                timeMillis += System.currentTimeMillis() - lastTimeStamp
                lastTimeStamp = System.currentTimeMillis()
                formattedTime = formatTime(timeMillis)
            }
        }
    }

    fun pause() {
        isActive = false
        isPaused = true // Set isPaused to true when paused
    }

    fun reset() {
        coroutineScope.cancel()
        coroutineScope = CoroutineScope(Dispatchers.Default)
        timeMillis = 0L
        lastTimeStamp = 0L
        formattedTime = "00:00:000"
        isActive = false
        isPaused = false // Reset isPaused when resetting
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun formatTime(timeMillis: Long): String {
        val localDateTime = LocalDateTime.ofInstant(
            Instant.ofEpochMilli(timeMillis),
            ZoneId.systemDefault()
        )

        val formatter = DateTimeFormatter.ofPattern(
            "mm:ss:SSS",
            Locale.getDefault()
        )

        return localDateTime.format(formatter)
    }
}