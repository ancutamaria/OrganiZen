package com.amg.organizen.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import com.amg.organizen.R
import com.amg.organizen.model.data.Quote
import com.amg.organizen.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var readingList: ConstraintLayout
    lateinit var shoppingList: TextView
    lateinit var quoteOfTheDay: TextView

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        quoteOfTheDay = findViewById(R.id.quote_of_the_day)
        quoteOfTheDay.setOnClickListener{
            startActivity(Intent(this, QuotesActivity::class.java))
        }

        readingList = findViewById(R.id.reading_list)


        shoppingList = findViewById(R.id.shopping_list)
        shoppingList.setOnClickListener{
            startActivity(Intent(this, ShoppingListActivity::class.java))
        }

    }

    private fun updateUI(msg: List<Quote>){
        var quote = msg.shuffled()?.take(1)?.get(0)
        quoteOfTheDay.text = quote?.quote + " - " + quote?.author
    }

    override fun onResume() {
        super.onResume()
        viewModel.quotes.observe(this){ response ->
            updateUI(response)
        }
    }
}