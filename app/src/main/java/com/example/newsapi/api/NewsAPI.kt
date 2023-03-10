package com.example.newsapi.api

import com.example.newsapi.Models.NewsResponse
import com.example.newsapi.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headline")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String= "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String=API_KEY
    ):Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String=API_KEY
    ):Response<NewsResponse>

}