package com.example.petvet_deanoc_josipstojanovic.data
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.petvet_deanoc_josipstojanovic.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LjubimacViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Ljubimac>>
    private val repository:LjubimacRepository
    init{
        val ljubimacDao = LjubimacDatabase.getDatabase(application).ljubimacDao()
        repository = LjubimacRepository(ljubimacDao)
        readAllData = repository.readAllData

    }
    fun populateDb(){
        /*
        val lj1 = Ljubimac(1, "Domaći Pas", "Canis Lupus familiaris", "${R.drawable.dog}" )
        val lj2 = Ljubimac(2, "Domaća Mačka", "Felis catus", "${R.drawable.cat}" )
        val lj3 = Ljubimac(3, "Hrčak", "Cavia porcellus", "${R.drawable.cat}" )
        val lj4 = Ljubimac(4, "Zec", "Lepus europaeus", "${R.drawable.cat}" )
        val lj5 = Ljubimac(5, "Papiga", "Psittacidae", "${R.drawable.cat}" )
        val lj6 = Ljubimac(6, "Kameleon", "Chamaeleonidae", "${R.drawable.cat}" )
        val lj7 = Ljubimac(7, "Konj", "Equus caballus", "${R.drawable.cat}" )
        val lj8 = Ljubimac(8, "Zlatna Ribica", "Carassius auratus", "${R.drawable.cat}" )
        val lj9 = Ljubimac(9, "Jež", "Erinaceidae", "${R.drawable.cat}" )
        viewModelScope.launch(Dispatchers.IO) {
            repository.addLjubimac(lj1)
            repository.addLjubimac(lj2)
            repository.addLjubimac(lj3)
            repository.addLjubimac(lj4)
            repository.addLjubimac(lj5)
            repository.addLjubimac(lj6)
            repository.addLjubimac(lj7)
            repository.addLjubimac(lj8)
            repository.addLjubimac(lj9)
        }*/
    }
    fun addLjubimac(ljubimac: Ljubimac){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addLjubimac(ljubimac)
        }
    }

}