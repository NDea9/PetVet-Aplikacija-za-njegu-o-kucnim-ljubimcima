package com.example.petvet_deanoc_josipstojanovic.data

import android.content.Context
import android.service.autofill.UserData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Ljubimac::class], version = 6, exportSchema = false)
abstract class LjubimacDatabase: RoomDatabase() {

    abstract fun ljubimacDao(): LjubimacDao

    companion object{
        @Volatile
        private var INSTANCE: LjubimacDatabase? = null

        fun getDatabase(context: Context): LjubimacDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LjubimacDatabase::class.java,
                    "ljubimac_database"
                ).fallbackToDestructiveMigration().createFromAsset("database/ljubimac_database.db").build()
                INSTANCE = instance
                return instance
            }
        }
    }

}