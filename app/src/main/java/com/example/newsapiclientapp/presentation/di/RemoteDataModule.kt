package com.example.newsapiclientapp.presentation.di

import com.example.newsapiclientapp.data.api.NewsAPIService
import com.example.newsapiclientapp.data.repository.datasource.NewsRemoteDataSource
import com.example.newsapiclientapp.data.repository.datasourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(newsAPIService: NewsAPIService): NewsRemoteDataSource{
        return NewsRemoteDataSourceImpl(newsAPIService)
    }
}
