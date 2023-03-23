package com.vb.numbersfacts.numberInput.model

import com.vb.numbersfacts.database.entity.NumberWithFact
import io.reactivex.rxjava3.core.Observable

interface NumberInputModel {
    fun getNumbersWithFacts() : Observable<List<NumberWithFact>>
    fun insertNumberWithFact(numberWithFact: NumberWithFact)
}
