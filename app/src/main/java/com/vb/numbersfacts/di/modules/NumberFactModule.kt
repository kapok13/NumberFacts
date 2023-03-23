package com.vb.numbersfacts.di.modules

import com.vb.numbersfacts.number.model.NumberApiService
import com.vb.numbersfacts.number.model.NumberModel
import com.vb.numbersfacts.number.model.NumberModelImpl
import com.vb.numbersfacts.number.presentation.NumberViewModel
import com.vb.numbersfacts.numberInput.model.NumberInputModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val numberFactModule = module {
    single<NumberModel> {
        NumberModelImpl(get(NumberApiService::class.java))
    }
    viewModel<NumberViewModel> {
        NumberViewModel(get(NumberModel::class.java), get(NumberInputModel::class.java))
    }
}
