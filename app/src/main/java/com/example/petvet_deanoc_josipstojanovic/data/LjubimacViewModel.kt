package com.example.petvet_deanoc_josipstojanovic.data
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LjubimacViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<Ljubimac>>
    private val repository:LjubimacRepository
    init{
        val ljubimacDao = LjubimacDatabase.getDatabase(application).ljubimacDao()
        repository = LjubimacRepository(ljubimacDao)
        readAllData = repository.readAllData

    }

    fun addLjubimac(ljubimac: Ljubimac){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addLjubimac(ljubimac)
        }
    }

}