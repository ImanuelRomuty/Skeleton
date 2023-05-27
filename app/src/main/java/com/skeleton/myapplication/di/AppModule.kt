package com.skeleton.myapplication.di

import com.example.storyappbiasa.storage.AppLocalData
import com.example.storyappbiasa.storage.Storage
import com.skeleton.myapplication.source.*
import com.skeleton.myapplication.storage.SharedPreferencesStorage
import com.skeleton.myapplication.ui.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single{ MainRemoteDataSource(get()) }
}

val repositoryModule = module {
    single<MainRepository>{ MainRepositoryImpl(get()) }
}

val viewModelModule = module {
    single{ MainViewModel(get()) }
}

val storageModule = module {
    single { AppLocalData(get()) }
    single<Storage> { SharedPreferencesStorage(androidContext()) }
}
