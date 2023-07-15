package com.example.petvet_deanoc_josipstojanovic

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class EvidencijaPreferencesDataStore(private val context: Context) {


    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("KljučŽivotinja")

        val KLJUČ = stringPreferencesKey("ključ_zivotinja")
        val IME = stringPreferencesKey("ime")
        val SPOL = stringPreferencesKey("spol")
        val VRSTA = stringPreferencesKey("vrsta")
        val KILAŽA = stringPreferencesKey("kilaža")
        val PREHRANA = stringPreferencesKey("prehrana")
    }
    // vratiSveZap.. nije testirana! Ne radi 100 %
    val vratiSveZapiseEvidencije: Flow<Preferences?> = context.dataStore.data

    // readAllKeys nije testirana! Ne radi 100 %
    suspend fun readAllKeys(): Set<Preferences.Key<*>>? {
        val keys = context.dataStore.data
            .map {
                it.asMap().keys
            }
        return keys.firstOrNull()
    }


    val getKljuč: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[KLJUČ] ?: ""
        }
    val getIme: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[IME] ?: ""
        }
    val getSpol: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[SPOL] ?: ""
        }
    val getVrsta: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[VRSTA] ?: ""
        }
    val getKilaža: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[KILAŽA] ?: ""
        }
    val getPrehrana: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[PREHRANA] ?: ""
        }
    // to save the email
    suspend fun saveKljuč(name: String) {
        context.dataStore.edit { preferences ->
            preferences[KLJUČ] = name
        }
    }
    suspend fun saveIme(name: String) {
        context.dataStore.edit { preferences ->
            preferences[IME] = name
        }
    }
    suspend fun saveSpol(name: String) {
        context.dataStore.edit { preferences ->
            preferences[SPOL] = name
        }
    }
    suspend fun saveVrsta(name: String) {
        context.dataStore.edit { preferences ->
            preferences[VRSTA] = name
        }
    }
    suspend fun saveKilaža(name: String) {
        context.dataStore.edit { preferences ->
            preferences[KILAŽA] = name
        }
    }
    suspend fun savePrehrana(name: String) {
        context.dataStore.edit { preferences ->
            preferences[PREHRANA] = name
        }
    }
}