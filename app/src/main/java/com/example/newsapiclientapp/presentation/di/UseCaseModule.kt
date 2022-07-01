package com.example.newsapiclientapp.presentation.di

import com.example.newsapiclientapp.domain.repository.NewsRepository
import com.example.newsapiclientapp.domain.usecase.GetNewsHeadlinesUseCase
import com.example.newsapiclientapp.domain.usecase.GetSearchedNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

   @Singleton
   @Provides
   fun provideGetNewsheadLinesUseCase(newsRepository: NewsRepository): GetNewsHeadlinesUseCase {
      return GetNewsHeadlinesUseCase(newsRepository)
   }

   @Singleton
   @Provides
   fun provideGetSearchedNewsUseCase(newsRepository: NewsRepository): GetSearchedNewsUseCase {
      return GetSearchedNewsUseCase(newsRepository)
   }
}


















