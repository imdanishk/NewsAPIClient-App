package com.example.newsapiclientapp.presentation.di

import com.example.newsapiclientapp.presentation.adapter.NewsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
class AdapterModule {

    @Singleton
    @Provides
    fun provideNewsAdapter() : NewsAdapter {
        return NewsAdapter()
    }
}