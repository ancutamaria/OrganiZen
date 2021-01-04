package com.amg.organizen.model

import java.util.*

data class Book(val id: UUID = UUID.randomUUID(),
                var title: String,
                var author: String)