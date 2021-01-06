package com.amg.organizen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amg.organizen.model.Book

private const val TAG = "BooksActivity"

class BookListFragment : Fragment() {

    private lateinit var bookRecyclerView: RecyclerView
    private var adapter: BookAdapter? = null

    companion object {
        fun newInstance(): BookListFragment {
            return BookListFragment()
        }
    }

    private val bookListViewModel: BookListViewModel by lazy {
        ViewModelProviders.of(this).get(BookListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total books: ${bookListViewModel.books.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.book_list_fragment, container, false)
        bookRecyclerView = view.findViewById(R.id.book_list_recycler_view)
        bookRecyclerView.layoutManager = LinearLayoutManager(context)

        updateUI()
        return view
    }

    private fun updateUI(){
        val books = bookListViewModel.books
        adapter = BookAdapter(books)
        bookRecyclerView.adapter = adapter
    }

    private inner class BookHolder(view: View): RecyclerView.ViewHolder(view){
        val book_title: TextView = itemView.findViewById(R.id.book_title)
        val book_author: TextView = itemView.findViewById(R.id.book_author)
    }

    private inner class BookAdapter(var books: List<Book>)
        : RecyclerView.Adapter<BookHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
            val view = layoutInflater.inflate(R.layout.book_list_item, parent, false)
            return BookHolder(view)
        }

        override fun onBindViewHolder(holder: BookHolder, position: Int) {
            val book = books[position]
            holder.apply {
                book_title.text = book.title
                book_author.text = book.author
            }
        }

        override fun getItemCount() = books.size

    }
}