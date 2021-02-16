package com.amg.organizen.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.amg.organizen.model.data.Quotes
import com.amg.organizen.model.repository.MyRepository
import com.amg.organizen.model.repository.MyResponse

class MainViewModel @ViewModelInject constructor(
    myRepository: MyRepository
) : ViewModel() {

    val quotes: LiveData<Quotes> = myRepository.getQuotes().asLiveData()

}