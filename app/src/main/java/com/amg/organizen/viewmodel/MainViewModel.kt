package com.amg.organizen.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.amg.organizen.model.data.Quote
import com.amg.organizen.model.repository.MyRepository

class MainViewModel @ViewModelInject constructor(
    myRepository: MyRepository
) : ViewModel() {

    val quotes: LiveData<List<Quote>> = myRepository.getQuotes().asLiveData()

}