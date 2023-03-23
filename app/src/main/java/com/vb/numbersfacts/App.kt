package com.vb.numbersfacts

import android.app.Application
import com.vb.numbersfacts.di.modules.databaseModule
import com.vb.numbersfacts.di.modules.networkModule
import com.vb.numbersfacts.di.modules.numberFactModule
import com.vb.numbersfacts.di.modules.numberInputModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(networkModule, numberFactModule, numberInputModule, databaseModule)
        }
    }
}
