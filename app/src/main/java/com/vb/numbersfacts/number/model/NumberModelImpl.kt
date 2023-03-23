package com.vb.numbersfacts.number.model

class NumberModelImpl(private val apiService: NumberApiService) : NumberModel {
    override fun getNumberFact(number: Int) = apiService.getNumberFact(number)
    override fun getRandomNumberFact() = apiService.getRandomNumberFact()
}
