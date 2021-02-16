package com.amg.organizen.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amg.organizen.R
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "QuotesActivity"

@AndroidEntryPoint
class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quote_list_activity)

        if (supportFragmentManager.findFragmentById(R.id.quote_list_fragment_container) == null){
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.quote_list_fragment_container, QuoteListFragment.newInstance())
                    .commit()
        }
    }
}