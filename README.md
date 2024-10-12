# Stopwatch App ⏱️

A simple stopwatch application built using **Jetpack Compose** in **Kotlin**. The app tracks time in milliseconds, allowing users to start, pause, resume, and reset the stopwatch, and displays the formatted time on the screen.

## Features
- **Start/Resume Functionality**: 
  - Start the stopwatch, and if paused, the button toggles to "Resume" to continue tracking time.
- **Pause and Reset**: 
  - Pause the stopwatch at any moment and reset it back to `00:00:000`.
- **Live Time Display**: 
  - Time is formatted and updated in real-time while the stopwatch is running.
- **Lifecycle Awareness**: 
  - Uses a `ViewModel` to handle stopwatch state, ensuring state persistence across configuration changes like screen rotations.
- **Material 3 Design**: 
  - The UI is styled with Material Design 3 for a modern and responsive look.

## Tech Stack
- **Kotlin**
- **Jetpack Compose**
- **Coroutines** for managing background tasks
- **ViewModel** for state management

## Screenshots
<table>
  <tr>
    <td><img src="https://github.com/abdo-essam/StopwatchApp/blob/master/screenshots/1.jpg" width="250"></td>
    <td><img src="https://github.com/abdo-essam/StopwatchApp/blob/master/screenshots/2.jpg" width="250"></td>
    <td><img src="https://github.com/abdo-essam/StopwatchApp/blob/master/screenshots/3.jpg" width="250"></td>
  </tr>
</table>

## How to Run
To run the app locally, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/stopwatch-app.git



