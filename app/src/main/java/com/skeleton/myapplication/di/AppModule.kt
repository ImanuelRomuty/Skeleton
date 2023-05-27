package com.skeleton.myapplication.di

import com.example.storyappbiasa.storage.AppLocalData
import com.example.storyappbiasa.storage.Storage
import com.skeleton.myapplication.source.home.HomeRemoteDataSource
import com.skeleton.myapplication.source.home.HomeRepository
import com.skeleton.myapplication.source.home.HomeRepositoryImpl
import com.skeleton.myapplication.storage.SharedPreferencesStorage
import com.skeleton.myapplication.ui.home.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single{ HomeRemoteDataSource(get()) }
}

val repositoryModule = module {
    single<HomeRepository>{ HomeRepositoryImpl(get()) }
}

val viewModelModule = module {
    single{ HomeViewModel(get()) }
}

val storageModule = module {
    single { AppLocalData(get()) }
    single<Storage> { SharedPreferencesStorage(androidContext()) }
}
