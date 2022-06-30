package com.example.newsapiclientapp.presentation.di

import android.app.Application
import com.example.newsapiclientapp.domain.usecase.GetNewsHeadlinesUseCase
import com.example.newsapiclientapp.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
class FactoryModule {

    @Singleton
    @Provides
  fun provideNewsViewModelFactory(
     application: Application,
     getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase
  ): NewsViewModelFactory {

      return NewsViewModelFactory(application, getNewsHeadlinesUseCase)
  }
}








