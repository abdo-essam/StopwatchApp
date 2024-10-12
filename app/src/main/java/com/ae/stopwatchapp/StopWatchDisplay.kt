package com.ae.stopwatchapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StopWatchDisplay(
    formattedTime: String,
    onStartClick: () -> Unit,
    onPauseClick: () -> Unit,
    onResetClick: () -> Unit,
    isPaused: Boolean, // Add a parameter to track pause state
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = formattedTime,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Spacer(Modifier.width(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(onClick = { onStartClick() }) {
                Text(if (isPaused) "Resume" else "Start") // Toggle button text
            }
            Spacer(Modifier.width(16.dp))
            Button(onPauseClick) {
                Text("Pause")
            }
            Spacer(Modifier.width(16.dp))
            Button(onResetClick) {
                Text("Reset")
            }
        }
    }
}