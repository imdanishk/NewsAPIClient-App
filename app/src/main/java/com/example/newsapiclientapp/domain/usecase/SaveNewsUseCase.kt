package com.example.newsapiclientapp.domain.usecase

import com.example.newsapiclientapp.data.model.Article
import com.example.newsapiclientapp.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) {
        return newsRepository.saveNews(article)
    }
}