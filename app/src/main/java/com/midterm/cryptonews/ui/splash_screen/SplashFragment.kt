package com.midterm.cryptonews.ui.splash_screen

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.midterm.cryptonews.R
import com.midterm.cryptonews.databinding.FragmentSplashBinding
import com.midterm.cryptonews.repository.Repository
import com.midterm.cryptonews.ui.base.BaseFragment
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashFragment :
    BaseFragment<FragmentSplashBinding, SplashFragmentViewModel>(FragmentSplashBinding::inflate) {

    override var useViewModelFactory = true
    private lateinit var auth: FirebaseAuth

    override fun init() {

        auth = Firebase.auth

        val currentUser = auth.currentUser

        if (currentUser != null) {
            delayedAnim(R.id.action_splashFragment_to_dashboardFragment)
        } else {
            delayedAnim(R.id.action_splashFragment_to_loginFragment)
        }

//        viewModel.usdToGel.observe(this,{
//            binding.tvAppName.text = it.usd_gel.toString()
//        })
        // viewModel.getUsdToGel()

    }

    private fun delayedAnim(id: Int) {
        binding.root.isClickable = false
        binding.root.isSoundEffectsEnabled = false

        binding.root.setOnClickListener {
            findNavController().navigate(id)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            withContext(Main) {
                delay(2000L)
                binding.root.performClick()
            }
        }
    }


    override fun getViewModel(): Class<SplashFragmentViewModel> =
        SplashFragmentViewModel::class.java

    override fun getFactory(): ViewModelProvider.Factory =
        SplashFragmentViewModelFactory(Repository())

}