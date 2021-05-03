package com.example.beritabagussn.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.beritabagussn.R
import com.example.beritabagussn.data.response.ArticlesItem
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(val listener: (ArticlesItem) -> Unit) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private var news = listOf<ArticlesItem>()

    fun setNews(news : List<ArticlesItem>) {
        this.news = news
        notifyDataSetChanged()
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(news: ArticlesItem) {
            itemView.tvTitle.text = news.title

            Glide.with(itemView.context)
                .load(news.urlToImage)
                .apply(RequestOptions().dontTransform().placeholder(R.drawable.ic_android_black_24dp))
                .into(itemView.ivNews)
            itemView.setOnClickListener {
                listener(news)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(View)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.bind(news[position])
    }

    override fun getItemCount(): Int {
        return news.size
    }

}