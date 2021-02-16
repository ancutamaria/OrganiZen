package com.amg.organizen.model.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amg.organizen.model.data.Quote

@Dao
interface QuoteDao {

    @Query("SELECT * FROM quote")
    fun getQuotes(): List<Quote>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addQuote(quote: Quote)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addQuotes(quotes: List<Quote>)

}