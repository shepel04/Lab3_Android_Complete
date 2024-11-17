package com.app.lab1

import androidx.lifecycle.ViewModel

class DogViewModel : ViewModel() {
    val dogList = mutableListOf<Dog>()
}
