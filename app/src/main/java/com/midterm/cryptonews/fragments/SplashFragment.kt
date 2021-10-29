package com.midterm.cryptonews.fragments

import androidx.lifecycle.ViewModelProvider
import com.midterm.cryptonews.bases.BaseFragment
import com.midterm.cryptonews.databinding.FragmentSplashBinding
import com.midterm.cryptonews.repository.Repository
import com.midterm.cryptonews.viewmodels.SplashFragmentViewModelFactory
import com.midterm.cryptonews.viewmodels.SplashFragmentViewModel

class SplashFragment : BaseFragment<FragmentSplashBinding, SplashFragmentViewModel>(FragmentSplashBinding::inflate) {

    override fun init() {
        viewModel.usdToGel.observe(this,{
            binding.tvAppName.text = it.usd_gel.toString()
        })
        viewModel.getUsdToGel()
    }

    override fun getViewModel(): Class<SplashFragmentViewModel> = SplashFragmentViewModel::class.java
    override fun getFactory(): ViewModelProvider.Factory = SplashFragmentViewModelFactory(Repository())

}