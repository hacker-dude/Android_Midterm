package com.midterm.cryptonews.fragments


import androidx.lifecycle.ViewModelProvider
import com.midterm.cryptonews.bases.BaseFragment
import com.midterm.cryptonews.databinding.FragmentLoginBinding
import com.midterm.cryptonews.viewmodels.LoginFragmentViewModel

class LoginFragment : BaseFragment<FragmentLoginBinding,LoginFragmentViewModel>(FragmentLoginBinding::inflate) {

    override fun init() {

    }

    override fun getFactory(): ViewModelProvider.Factory? = null
    override fun getViewModel(): Class<LoginFragmentViewModel> = LoginFragmentViewModel::class.java
}