package com.amg.organizen.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class Quote (@PrimaryKey val id: Int, val quote: String, val author: String)