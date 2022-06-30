package com.example.newsapiclientapp.domain.usecase

import com.example.newsapiclientapp.data.model.Article
import com.example.newsapiclientapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {

    fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }
}