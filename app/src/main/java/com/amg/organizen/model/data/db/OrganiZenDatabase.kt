package com.amg.organizen.model.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amg.organizen.model.data.Quote

@Database(entities = [Quote::class], version = 1)
abstract class OrganiZenDatabase: RoomDatabase() {

    abstract fun quotesDao(): QuoteDao

}