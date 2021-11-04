package com.midterm.cryptonews.ui.splash_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.midterm.cryptonews.repository.Repository

class SplashFragmentViewModelFactory(private val repository:Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SplashFragmentViewModel(repository) as T
    }
}