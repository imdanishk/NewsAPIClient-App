package com.example.newsapiclientapp.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapiclientapp.data.model.APIResponse
import com.example.newsapiclientapp.data.util.Resource
import com.example.newsapiclientapp.domain.usecase.GetNewsHeadlinesUseCase
import com.example.newsapiclientapp.domain.usecase.GetSearchedNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.http.Query

class NewsViewModel(
    private val app: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase
) : AndroidViewModel(app) {

    val newsHeadLines: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getNewsHeadLines(country: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        newsHeadLines.postValue(Resource.Loading())
        try{
            if(isNetworkAvailable(app)) {

                val apiResult = getNewsHeadlinesUseCase.execute(country, page)
                newsHeadLines.postValue(apiResult)
            }else{
                newsHeadLines.postValue(Resource.Error("Internet is not available"))
            }

        }catch (e:Exception){
            newsHeadLines.postValue(Resource.Error(e.message.toString()))
        }

    }

    private fun isNetworkAvailable(context: Context?):Boolean{
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false

    }

    // Search
    val searchNews: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getSearchedNews(country: String, searchQuery: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        searchNews.postValue(Resource.Loading())
        try{
            if(isNetworkAvailable(app)) {
                val response = getSearchedNewsUseCase.execute(country, searchQuery, page)
                searchNews.postValue(response)
            }else{
                searchNews.postValue(Resource.Error("Internet is not available"))
            }

        }catch (e:Exception){
            searchNews.postValue(Resource.Error(e.message.toString()))
        }

    }

}


