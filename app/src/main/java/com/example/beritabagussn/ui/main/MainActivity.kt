package com.example.beritabagussn.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beritabagussn.R
import com.example.beritabagussn.data.remote.ApiClient
import com.example.beritabagussn.data.response.ArticlesItem
import com.example.beritabagussn.data.response.NewsResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
        initRecycleView()
    }

    private fun initRecycleView() {
        adapter = NewsAdapter {

        }
        rvNews.layoutManager = LinearLayoutManager(this)
        rvNews.adapter = adapter
    }

    private fun getNews() {
        ApiClient.create().getNews().enqueue(object : Callback<NewsResponse>{
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                   val articles : List<ArticlesItem> =  response.body()?.articles as List<ArticlesItem>
                    adapter.setNews(articles)
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {

            }

        })
    }
}