package com.amg.organizen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    lateinit var readingList: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        readingList = findViewById(R.id.reading_list)
        // TODO make entire constraintLayout content respond to anClick
        readingList.setOnClickListener{
            startActivity(Intent(this, BooksActivity::class.java))
        }
    }
}