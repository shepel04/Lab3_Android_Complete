package com.app.lab1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val _itemList = MutableLiveData<List<ListItem>>(emptyList())
    val itemList: LiveData<List<ListItem>> = _itemList

    private val imageIdList = listOf(
        R.drawable.beagle,
        R.drawable.corgy,
        R.drawable.dachshund,
        R.drawable.german_shepherd,
        R.drawable.golden_retriever,
    )
    private var index = 0
    private var showDog = true

    fun addNextItem() {
        val currentList = _itemList.value.orEmpty().toMutableList()
        if (showDog) {
            if (index >= imageIdList.size) index = 0
            currentList.add(DogItem(imageIdList[index], "Dog $index"))
            index++
        } else {
            currentList.add(HeaderItem("Dog ${currentList.size} description"))
        }
        showDog = !showDog
        _itemList.value = currentList
    }
}
