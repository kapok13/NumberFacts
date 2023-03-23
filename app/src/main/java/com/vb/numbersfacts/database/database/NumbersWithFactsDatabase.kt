package com.vb.numbersfacts.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vb.numbersfacts.database.dao.NumberDao
import com.vb.numbersfacts.database.entity.NumberWithFact

@Database(entities = [NumberWithFact::class], version = 1)
abstract class NumbersWithFactsDatabase : RoomDatabase() {
    abstract fun numberDao(): NumberDao
}
