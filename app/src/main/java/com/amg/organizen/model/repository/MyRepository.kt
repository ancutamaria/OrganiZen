package com.amg.organizen.model.repository

import com.amg.organizen.model.data.db.QuoteDao
import com.amg.organizen.model.repository.rest.MyAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MyRepository @Inject constructor(
    private val apiService: MyAPIService, private val quoteDao: QuoteDao
){

    fun getQuotes() = flow {
        var quotes = quoteDao.getQuotes()
        if (quotes.isEmpty()){
            quoteDao.addQuotes(apiService.getQuotes().quotes)
        }
        emit(quoteDao.getQuotes())
    }.flowOn(Dispatchers.IO)
}
