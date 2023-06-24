package com.example.petvet_deanoc_josipstojanovic.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LjubimacDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLjubimac(ljubimac: Ljubimac)

    @Query("SELECT * FROM ljubimac_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Ljubimac>>
}