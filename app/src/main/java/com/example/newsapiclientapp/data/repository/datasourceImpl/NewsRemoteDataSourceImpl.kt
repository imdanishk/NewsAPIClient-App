package com.example.newsapiclientapp.data.repository.datasourceImpl

import com.example.newsapiclientapp.data.api.NewsAPIService
import com.example.newsapiclientapp.data.model.APIResponse
import com.example.newsapiclientapp.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
): NewsRemoteDataSource {

    override suspend fun getTopHeadlines(country: String, page: Int): Response<APIResponse> {
          return newsAPIService.getTopHeadlines(country,page)
    }
}