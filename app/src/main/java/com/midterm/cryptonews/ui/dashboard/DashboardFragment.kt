package com.midterm.cryptonews.ui.dashboard

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.midterm.cryptonews.R
import com.midterm.cryptonews.databinding.FragmentDashboardBinding
import com.midterm.cryptonews.ui.base.BaseFragment


class DashboardFragment :
    BaseFragment<FragmentDashboardBinding, DashboardViewModel>(FragmentDashboardBinding::inflate) {
    private lateinit var auth: FirebaseAuth
    override fun init() {
        auth = Firebase.auth
        val user = auth.currentUser

        binding.tvUser.text = user!!.email

        binding.btnProfile.setOnClickListener {
            Firebase.auth.signOut()
            findNavController().navigate(R.id.action_dashboardFragment_to_loginFragment)
        }

        binding.btnList.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_coinListFragment)
        }
    }

    override fun getFactory(): ViewModelProvider.Factory? = null

    override fun getViewModel(): Class<DashboardViewModel> =
        DashboardViewModel::class.java

}