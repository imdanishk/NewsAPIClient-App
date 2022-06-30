package com.example.newsapiclientapp.domain.repository

import com.example.newsapiclientapp.data.model.APIResponse
import com.example.newsapiclientapp.data.model.Article
import com.example.newsapiclientapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNewsHeadlines(): Resource<APIResponse>
    suspend fun getSearchedNews(searchQuery:String) : Resource<APIResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}