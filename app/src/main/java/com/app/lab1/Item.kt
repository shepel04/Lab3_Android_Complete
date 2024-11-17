package com.app.lab1

data class DogItem(val imageId: Int, val title: String) : ListItem {
    override val type = ITEM_TYPE_DOG
}

data class HeaderItem(val header: String) : ListItem {
    override val type = ITEM_TYPE_HEADER
}

const val ITEM_TYPE_DOG = 0
const val ITEM_TYPE_HEADER = 1
