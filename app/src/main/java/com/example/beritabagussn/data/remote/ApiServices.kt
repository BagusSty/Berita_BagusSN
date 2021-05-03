package com.example.beritabagussn.data.remote

import retrofit2.Call
import com.example.beritabagussn.data.response.NewsResponse
import retrofit2.http.GET

interface ApiServices {

    @GET ("https://newsapi.org/v2/top-headlines?country=id&apiKey=dc269b6587064cef94f4d9afaa19cf94")
    fun getNews() : Call<NewsResponse>
}