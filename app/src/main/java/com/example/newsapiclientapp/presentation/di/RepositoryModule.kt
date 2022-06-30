package com.example.newsapiclientapp.presentation.di

import com.example.newsapiclientapp.data.repository.NewsRepositoryImpl
import com.example.newsapiclientapp.data.repository.datasource.NewsRemoteDataSource
import com.example.newsapiclientapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(newsRemoteDataSource: NewsRemoteDataSource): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource)
    }
}