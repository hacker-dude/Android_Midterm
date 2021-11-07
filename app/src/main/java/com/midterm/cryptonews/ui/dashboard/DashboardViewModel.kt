package com.midterm.cryptonews.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.midterm.cryptonews.repository.Repository
import com.midterm.cryptonews.ui.dashboard.source.NewsPagingSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class DashboardViewModel(private val repository: Repository) : ViewModel(){
    fun usersFlow() =
        Pager(
            config = PagingConfig(pageSize = 1,maxSize = 200),
            pagingSourceFactory = { NewsPagingSource(repository) })
            .flow.cachedIn(CoroutineScope(Dispatchers.Main))
}
