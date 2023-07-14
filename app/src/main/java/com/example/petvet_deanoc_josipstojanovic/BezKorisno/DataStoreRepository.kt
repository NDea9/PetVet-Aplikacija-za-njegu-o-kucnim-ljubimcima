package com.example.petvet_deanoc_josipstojanovic.BezKorisno

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

// prilagodit da radi za podatak tip ZnacajkeMogLjubimca
const val PREFERENCE_NAME = "moj_ljubimac"
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCE_NAME)
class DataStoreRepository(private val context: Context){
    private object PreferenceKeys {
        val name = stringPreferencesKey(PREFERENCE_NAME)
    }

    suspend fun saveToDataStore(genericki_podatak: ZnacajkeMogLjubimca){
        val readFromDataStore: Flow<String> = context.dataStore.data
            .catch { exception ->
                if(exception is IOException){
                    Log.d("DataStore", exception.message.toString())
                    emit(emptyPreferences())
                }else {
                    throw exception
                }
            }
            .map { preference ->
                val myName = preference[PreferenceKeys.name] ?: "none"
                myName
            }
    }
}
