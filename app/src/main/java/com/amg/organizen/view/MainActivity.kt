package com.amg.organizen.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.amg.organizen.R
import com.amg.organizen.model.data.Quote
import com.amg.organizen.model.data.Quotes
import com.amg.organizen.model.repository.MyResponse
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

        readingList = findViewById(R.id.reading_list)
        readingList.setOnClickListener{
            startActivity(Intent(this, BooksActivity::class.java))
        }

        shoppingList = findViewById(R.id.shopping_list)
        shoppingList.setOnClickListener{
            startActivity(Intent(this, ShoppingListActivity::class.java))
        }

        viewModel.quotes.observe(this){ response ->
            when (response) {
                is MyResponse.OK -> {
                    updateUI(response)
                }
                is MyResponse.Error -> {
                    AlertDialog.Builder(this)
                        .setMessage(response.message)
                        .setPositiveButton("OK") { _,_ -> }
                        .create()
                        .show()
                }
            }

        }
    }

    private fun updateUI(msg: MyResponse.OK<Quotes>){
        var quote = msg.data?.quotes?.shuffled()?.take(1)?.get(0)
        quoteOfTheDay.text = quote?.quote + " - " + quote?.author
    }
}