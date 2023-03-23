package com.vb.numbersfacts.number.model

import io.reactivex.rxjava3.core.Observable

interface NumberModel {
    fun getNumberFact(number: Int) : Observable<NumberResponse>
    fun getRandomNumberFact() : Observable<NumberResponse>
}
