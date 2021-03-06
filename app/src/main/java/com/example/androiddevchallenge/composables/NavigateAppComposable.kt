package com.example.androiddevchallenge.composables

import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.AppState
import com.example.androiddevchallenge.CurrentScreen
import com.example.androiddevchallenge.viewModel.HomeViewModel

@Composable
fun NavigateApp(appState: AppState, homeViewModel: HomeViewModel) {
    // Choose which screen to show based on the value in the currentScreen variable inside AppState
    when (appState.currentScreen) {
        CurrentScreen.HOME -> HomeComposable(appState, homeViewModel)
        //CurrentScreen.DETAIL -> DetailComposable(appState, homeViewModel)
    }
}