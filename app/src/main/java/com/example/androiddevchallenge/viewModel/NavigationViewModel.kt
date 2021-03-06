package com.example.androiddevchallenge.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.ui.Screen
import com.jarroyo.sharedcodeclient.domain.model.Breed

class NavigationViewModel@ViewModelInject constructor(
): ViewModel() {
    private val _currentScreen = MutableLiveData<Screen>(Screen.BreedsList)
    val currentScreen: LiveData<Screen> = _currentScreen

    fun onBackPressed(): Boolean {
        val current = _currentScreen.value == Screen.BreedsList
        _currentScreen.value = Screen.BreedsList
        return current
    }

    fun onBreedSelected(breed: Breed) {
        _currentScreen.value = Screen.BreedDetails(breed)
    }

}