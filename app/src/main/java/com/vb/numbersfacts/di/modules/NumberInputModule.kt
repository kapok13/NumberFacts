package com.vb.numbersfacts.di.modules

import com.vb.numbersfacts.database.database.NumbersWithFactsDatabase
import com.vb.numbersfacts.numberInput.model.NumberInputModel
import com.vb.numbersfacts.numberInput.model.NumberInputModelImpl
import com.vb.numbersfacts.numberInput.presentation.NumberInputViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val numberInputModule = module {
    single<NumberInputModel> {
        NumberInputModelImpl(get(NumbersWithFactsDatabase::class.java))
    }
    viewModel<NumberInputViewModel> {
        NumberInputViewModel(get(NumberInputModel::class.java))
    }
}
