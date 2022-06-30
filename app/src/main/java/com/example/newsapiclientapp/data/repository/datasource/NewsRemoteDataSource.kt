package com.example.newsapiclientapp.data.repository.datasource

import com.example.newsapiclientapp.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(country: String, page: Int):Response<APIResponse>
}