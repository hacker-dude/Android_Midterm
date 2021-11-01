package com.midterm.cryptonews.fragments

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.midterm.cryptonews.R
import com.midterm.cryptonews.bases.BaseFragment
import com.midterm.cryptonews.databinding.FragmentDashboardBinding
import com.midterm.cryptonews.viewmodels.DashboardFragmentViewModel


class DashboardFragment :
    BaseFragment<FragmentDashboardBinding, DashboardFragmentViewModel>(FragmentDashboardBinding::inflate) {
    private lateinit var auth: FirebaseAuth

    override fun init() {
        auth = Firebase.auth
        val user = auth.currentUser
        binding.tvUser.text = user!!.email
        binding.btnSingOut.setOnClickListener {
            Firebase.auth.signOut()
            findNavController().navigate(R.id.action_dashboardFragment_to_loginFragment)
        }
    }

    override fun getFactory(): ViewModelProvider.Factory? = null

    override fun getViewModel(): Class<DashboardFragmentViewModel> =
        DashboardFragmentViewModel::class.java

}