package com.example.newsapiclientapp.presentation.di

import android.app.Application
import com.example.newsapiclientapp.domain.usecase.GetNewsHeadlinesUseCase
import com.example.newsapiclientapp.domain.usecase.GetSearchedNewsUseCase
import com.example.newsapiclientapp.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
  fun provideNewsViewModelFactory(
     application: Application,
     getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
     getSearchedNewsUseCase: GetSearchedNewsUseCase
  ): NewsViewModelFactory {

      return NewsViewModelFactory(application, getNewsHeadlinesUseCase, getSearchedNewsUseCase)
  }
}








