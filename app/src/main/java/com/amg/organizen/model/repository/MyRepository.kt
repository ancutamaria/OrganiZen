package com.amg.organizen.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amg.organizen.model.data.Quotes
import com.amg.organizen.model.repository.rest.MyAPIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MyRepository @Inject constructor(
    private val apiService: MyAPIService
){

    fun getQuotes(): LiveData<MyResponse<Quotes>>{
        val myResponse = MutableLiveData<MyResponse<Quotes>>()

        apiService.getQuotes().enqueue(object : Callback<Quotes> {
            override fun onResponse(call: Call<Quotes>, response: Response<Quotes>) {
                val responseTmp: Quotes? = response.body()
                myResponse.value = MyResponse.OK(responseTmp)
            }
            override fun onFailure(call: Call<Quotes>, t: Throwable) {
                myResponse.value =
                        MyResponse.Error("Error on trying to access REST: \n ${t.message}")
            }
        })
        return myResponse
    }
}
