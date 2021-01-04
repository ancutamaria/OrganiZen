package com.amg.organizen

import androidx.lifecycle.ViewModel
import com.amg.organizen.model.Book

class BookListViewModel: ViewModel() {

    val books = mutableListOf<Book>()

    init {
        for (i in 0 until 100){
            val book = Book(author = "Author $i", title = "Title $i")
            books += book
        }
    }
}