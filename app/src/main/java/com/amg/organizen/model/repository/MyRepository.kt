package com.amg.organizen.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amg.organizen.model.data.Quotes
import com.amg.organizen.model.repository.rest.MyAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MyRepository @Inject constructor(
    private val apiService: MyAPIService
){

    fun getQuotes() = flow {
        emit(apiService.getQuotes())
    }.flowOn(Dispatchers.IO)
}
