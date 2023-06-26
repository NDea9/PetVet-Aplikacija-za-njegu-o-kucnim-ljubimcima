package com.example.petvet_deanoc_josipstojanovic.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ljubimac_table")
data class Ljubimac(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val ime: String,
    val imeLatinsko: String,
    val urlSlika: String,
)