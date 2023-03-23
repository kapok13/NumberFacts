package com.vb.numbersfacts.numberInput.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vb.numbersfacts.database.entity.NumberWithFact
import com.vb.numbersfacts.numberInput.model.NumberInputModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class NumberInputViewModel(private val numberInputModel: NumberInputModel) : ViewModel() {
    fun getNumberWithFacts(): MutableLiveData<List<NumberWithFact>> {
        val response = MutableLiveData<List<NumberWithFact>>()
        numberInputModel.getNumbersWithFacts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                response.value = it
            }
        return response
    }
}
