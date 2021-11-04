package com.midterm.cryptonews.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.midterm.cryptonews.repository.Repository
import com.midterm.cryptonews.viewmodels.CoinListFragmentViewModel

class CoinListFragmentViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CoinListFragmentViewModel(repository) as T
    }
}