package com.midterm.cryptonews.ui.dashboard.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.midterm.cryptonews.models.NewsModel
import com.midterm.cryptonews.repository.Repository

class NewsPagingSource(private val newsRepository: Repository) :
    PagingSource<Int, NewsModel.Result>() {
    override fun getRefreshKey(state: PagingState<Int, NewsModel.Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsModel.Result> {
        val pageNumber = params.key ?: 1

        val response = newsRepository.getNews(pageNumber, arrayListOf("crypto","bitcoin","dogecoin","ethereum","coin","blockchain"))
        return if (response.isSuccessful) {
                var preview: Int? = null
                var next: Int? = null
                val body = response.body()!!
                if (body.nextPage != null)
                    next = pageNumber + 1
                if (pageNumber != 1)
                    preview = pageNumber - 1
                LoadResult.Page(data = body.results!!, prevKey = preview, nextKey = next)
            }else {
            LoadResult.Error(Throwable())
        }
    }

}