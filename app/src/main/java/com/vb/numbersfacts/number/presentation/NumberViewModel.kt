package com.vb.numbersfacts.number.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vb.numbersfacts.database.entity.NumberWithFact
import com.vb.numbersfacts.number.model.NumberModel
import com.vb.numbersfacts.number.model.NumberResponse
import com.vb.numbersfacts.numberInput.model.NumberInputModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class NumberViewModel(
    private val numberModel: NumberModel,
    private val numberInputModel: NumberInputModel
) : ViewModel() {

    fun getNumberFact(number: Int?): MutableLiveData<NumberResponse> {
        val response = MutableLiveData<NumberResponse>()
        if (number != null) {
            numberModel.getNumberFact(number)
        } else {
            numberModel.getRandomNumberFact()
        }
            .switchMap {
                numberInputModel.insertNumberWithFact(NumberWithFact(it.number, it.text))
                Observable.just(it)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                response.value = it
            }
        return response
    }
}
