package com.midterm.cryptonews.ui.coin_chooser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.midterm.cryptonews.repository.Repository

class CoinListViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CoinChooserViewModel(repository) as T
    }
}