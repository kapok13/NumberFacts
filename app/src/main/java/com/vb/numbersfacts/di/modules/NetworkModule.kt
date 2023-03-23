package com.vb.numbersfacts.di.modules

import com.vb.numbersfacts.number.model.NumberApiService
import org.koin.core.scope.get
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

private val NUMBERS_API_URL = "http://numbersapi.com/"

val networkModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(NUMBERS_API_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
    single<NumberApiService> {
        (get(Retrofit::class.java) as Retrofit).create(NumberApiService::class.java)
    }
}
