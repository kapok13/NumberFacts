package com.vb.numbersfacts.numberInput.model

import com.vb.numbersfacts.database.database.NumbersWithFactsDatabase
import com.vb.numbersfacts.database.entity.NumberWithFact
import io.reactivex.rxjava3.core.Observable

class NumberInputModelImpl(
    private val numbersWithFactsDatabase: NumbersWithFactsDatabase
) : NumberInputModel {
    override fun getNumbersWithFacts(): Observable<List<NumberWithFact>> = numbersWithFactsDatabase.numberDao().getNumbers()

    override fun insertNumberWithFact(numberWithFact: NumberWithFact) = numbersWithFactsDatabase.numberDao().insert(numberWithFact)
}
