package com.amg.organizen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ShoppingListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_list_activity)

        if (supportFragmentManager.findFragmentById(R.id.shopping_list_fragment_container) == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.shopping_list_fragment_container, ShoppingListFragment.newInstance())
                .commit()
        }
    }
}