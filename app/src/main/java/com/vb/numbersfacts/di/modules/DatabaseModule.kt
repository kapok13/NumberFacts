package com.vb.numbersfacts.di.modules

import androidx.room.Room
import com.vb.numbersfacts.database.database.NumbersWithFactsDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private val DATABASE_NAME = "numbers_with_facts_db"

val databaseModule = module {
    single<NumbersWithFactsDatabase> {
        Room.databaseBuilder(
            androidContext(),
            NumbersWithFactsDatabase::class.java, DATABASE_NAME
        ).build()
    }
}
