package com.amg.organizen.model.repository.rest

import com.amg.organizen.model.data.Quotes
import retrofit2.Call
import retrofit2.http.GET


interface MyAPIService {

    @GET("/b/01MF")
    fun getQuotes(): Call<Quotes>

}