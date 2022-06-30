package com.example.newsapiclientapp.domain.usecase

import com.example.newsapiclientapp.data.model.APIResponse
import com.example.newsapiclientapp.data.util.Resource
import com.example.newsapiclientapp.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(searchQuery:String): Resource<APIResponse> {
        return newsRepository.getSearchedNews(searchQuery)
    }
}