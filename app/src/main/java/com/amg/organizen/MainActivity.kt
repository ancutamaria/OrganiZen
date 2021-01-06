package com.amg.organizen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    lateinit var readingList: ConstraintLayout
    lateinit var shoppingList: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        readingList = findViewById(R.id.reading_list)
        readingList.setOnClickListener{
            startActivity(Intent(this, BooksActivity::class.java))
        }

        shoppingList = findViewById(R.id.shopping_list)
        shoppingList.setOnClickListener{
            startActivity(Intent(this, ShoppingListActivity::class.java))
        }
    }
}