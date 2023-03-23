package com.vb.numbersfacts.number.model

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface NumberApiService {
    @GET("{number}?json")
    fun getNumberFact(@Path("number") number: Int) : Observable<NumberResponse>
    @GET("random/math?json")
    fun getRandomNumberFact() : Observable<NumberResponse>
}
