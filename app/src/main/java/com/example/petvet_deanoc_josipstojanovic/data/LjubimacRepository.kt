package com.example.petvet_deanoc_josipstojanovic.data

import androidx.lifecycle.LiveData

class LjubimacRepository(private val ljubimacDao: LjubimacDao) {

    val readAllData: LiveData<List<Ljubimac>> = ljubimacDao.readAllData()

    suspend fun addLjubimac(ljubimac: Ljubimac){
        ljubimacDao.addLjubimac( ljubimac )
    }
}