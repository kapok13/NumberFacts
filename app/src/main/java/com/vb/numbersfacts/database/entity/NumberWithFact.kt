package com.vb.numbersfacts.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "numbers_with_fact")
data class NumberWithFact(
    val number: Int,
    val fact : String
) {
    @PrimaryKey(autoGenerate = true) var id: Int? = null
}
