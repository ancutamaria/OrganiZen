package com.amg.organizen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

private const val TAG = "BooksActivity"

class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_list_activity)

        if (supportFragmentManager.findFragmentById(R.id.book_list_fragment_container) == null){
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.book_list_fragment_container, BookListFragment.newInstance())
                    .commit()
        }
    }
}