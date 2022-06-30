package com.example.newsapiclientapp.domain.usecase

import com.example.newsapiclientapp.data.model.APIResponse
import com.example.newsapiclientapp.data.util.Resource
import com.example.newsapiclientapp.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, page: Int): Resource<APIResponse> {
        return newsRepository.getNewsHeadlines(country, page)
    }
}