package com.vb.numbersfacts.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vb.numbersfacts.database.entity.NumberWithFact
import io.reactivex.rxjava3.core.Observable

@Dao
interface NumberDao {
    @Query("SELECT * FROM numbers_with_fact")
    fun getNumbers(): Observable<List<NumberWithFact>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(numberWithFact: NumberWithFact)
}
