package com.skeleton.myapplication

import android.app.Application
import com.skeleton.myapplication.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin{
            androidContext(this@MyApplication)
            modules(
                networkModule,
                viewModelModule,
                remoteDataSourceModule,
                repositoryModule,
                storageModule,
                databaseModule
            )
        }
    }
}