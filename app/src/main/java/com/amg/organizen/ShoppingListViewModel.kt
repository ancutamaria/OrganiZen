package com.amg.organizen

import androidx.lifecycle.ViewModel
import com.amg.organizen.model.ShoppingItem

class ShoppingListViewModel: ViewModel() {

    val shoppingItems = mutableListOf<ShoppingItem>()

    init {
        for (i in 0 until 100){
            val shoppingItem = ShoppingItem(title = "Shopping item ${i + 1}")
            shoppingItems += shoppingItem
        }
    }
}