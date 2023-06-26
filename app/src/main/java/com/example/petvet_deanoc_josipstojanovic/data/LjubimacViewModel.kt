package com.example.petvet_deanoc_josipstojanovic.data
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
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
        val lj1 = Ljubimac(1, "Pas", "Pasus", "https://media.istockphoto.com/id/1306641965/photo/cobberdog-pup-on-white-background.jpg?s=2048x2048&w=is&k=20&c=l34bim3_Gzjp0j-wNcs3llPMZReCOScrg16AqEaKrqw=" )
        val lj2 = Ljubimac(2, "Maca", "Macus", "https://media.istockphoto.com/id/1361394182/photo/funny-british-shorthair-cat-portrait-looking-shocked-or-surprised.jpg?s=2048x2048&w=is&k=20&c=80OmuSCyHtOi_jqkyd4yyDjja73qPSnH3vgzRgXIIUg=" )

        viewModelScope.launch(Dispatchers.IO) {
            repository.addLjubimac(lj1)
            repository.addLjubimac(lj2)
        }
    }
    fun addLjubimac(ljubimac: Ljubimac){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addLjubimac(ljubimac)
        }
    }

}