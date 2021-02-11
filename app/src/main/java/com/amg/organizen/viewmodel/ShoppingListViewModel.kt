package com.amg.organizen.viewmodel

import androidx.lifecycle.ViewModel
import com.amg.organizen.model.data.ShoppingItem

class ShoppingListViewModel: ViewModel() {

    val shoppingItems = mutableListOf<ShoppingItem>()

    init {
        for (i in 0 until 100){
            val shoppingItem = ShoppingItem(title = "Shopping item ${i + 1}")
            shoppingItems += shoppingItem
        }
    }
}