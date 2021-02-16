package com.amg.organizen.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amg.organizen.R
import com.amg.organizen.model.data.Quote
import com.amg.organizen.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "QuotesActivity"

@AndroidEntryPoint
class QuoteListFragment : Fragment() {

    private lateinit var quoteRecyclerView: RecyclerView
    private var adapter: QuoteAdapter? = null

    companion object {
        fun newInstance(): QuoteListFragment {
            return QuoteListFragment()
        }
    }

    private val viewModel: QuoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.quote_list_fragment, container, false)
        quoteRecyclerView = view.findViewById(R.id.quote_list_recycler_view)
        quoteRecyclerView.layoutManager = LinearLayoutManager(context)
        viewModel.quotes.observe(viewLifecycleOwner) { quotes ->
            updateUI(quotes)
        }
        return view
    }

    private fun updateUI(quotes: List<Quote>){
        adapter = QuoteAdapter(quotes)
        quoteRecyclerView.adapter = adapter
    }

    private inner class QuoteHolder(view: View): RecyclerView.ViewHolder(view){
        val quoteView: TextView = itemView.findViewById(R.id.quote_view)
    }

    private inner class QuoteAdapter(var quotes: List<Quote>)
        : RecyclerView.Adapter<QuoteHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteHolder {
            val view = layoutInflater.inflate(R.layout.quote_list_item, parent, false)
            return QuoteHolder(view)
        }

        override fun onBindViewHolder(holder: QuoteHolder, position: Int) {
            val quote = quotes[position]
            holder.apply {
                quoteView.text = quote.quote + " - " + quote.author
            }
        }

        override fun getItemCount() = quotes.size

    }
}