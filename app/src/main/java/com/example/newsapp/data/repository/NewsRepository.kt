package com.example.newsapp.data.repository

import android.content.Context
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.newsapp.R
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.remote.NewsApi
import com.example.newsapp.data.remote.NewsPagingSource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(
    private val api: NewsApi,
    @ApplicationContext private val context: Context
) {
    fun getTopHeadlines(): Pager<Int, Article> = Pager(
        config = PagingConfig(pageSize = 20),
        pagingSourceFactory = {
            NewsPagingSource(api, context.getString(R.string.news_api_key))
        }
    )
}
