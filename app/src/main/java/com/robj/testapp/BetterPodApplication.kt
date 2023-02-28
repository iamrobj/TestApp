package com.robj.testapp

import android.app.Application
import com.robj.testapp.di.appModule
import com.robj.testapp.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class TestAppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        GlobalContext.startKoin {
            androidLogger(Level.NONE)
            androidContext(this@TestAppApplication)
            modules(repositoryModule, appModule)
        }
    }
}