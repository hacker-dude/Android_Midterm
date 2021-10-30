package com.midterm.cryptonews.fragments

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.midterm.cryptonews.R
import com.midterm.cryptonews.bases.BaseFragment
import com.midterm.cryptonews.databinding.FragmentSplashBinding
import com.midterm.cryptonews.repository.Repository
import com.midterm.cryptonews.viewmodels.SplashFragmentViewModelFactory
import com.midterm.cryptonews.viewmodels.SplashFragmentViewModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashFragment : BaseFragment<FragmentSplashBinding, SplashFragmentViewModel>(FragmentSplashBinding::inflate) {

    override var useViewModelFactory = true

    override fun init() {

        viewModel.usdToGel.observe(this,{
            binding.tvAppName.text = it.usd_gel.toString()
        })
        delayedAnim()
        // viewModel.getUsdToGel()

    }

    private fun delayedAnim(){
        binding.root.isClickable = false
        binding.root.isSoundEffectsEnabled = false

        binding.root.setOnClickListener {
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            withContext(Main){
                delay(3000L)
                binding.root.performClick()
            }
        }
    }


    override fun getViewModel(): Class<SplashFragmentViewModel> = SplashFragmentViewModel::class.java
    override fun getFactory(): ViewModelProvider.Factory = SplashFragmentViewModelFactory(Repository())

}