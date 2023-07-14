package com.example.petvet_deanoc_josipstojanovic.BezKorisno

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.petvet_deanoc_josipstojanovic.BezKorisno.DataStoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ZnacajkeMogLjubimcaViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = DataStoreRepository(application)

    //val readFromDataStore = repository.readFromDataStore.asLiveData()

    fun saveToDataStore(myName: String) = viewModelScope.launch(Dispatchers.IO) {
        //repository.saveToDataStore(myName)
    }
}