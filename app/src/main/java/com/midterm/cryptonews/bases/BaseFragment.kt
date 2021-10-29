package com.midterm.cryptonews.bases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.midterm.cryptonews.repository.Repository

typealias Inflate<T> = (LayoutInflater, ViewGroup, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding,VM : ViewModel>(private val inflate: Inflate<VB>) :
    Fragment() {

    private var _binding: VB? = null
    val binding get() = _binding!!

    open lateinit var viewModel: VM

    open var useSharedViewModel: Boolean = false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container!!, false)
        // viewModel = ViewModelProvider(this).get(getViewModel())
        createViewModel()
        init()
        return _binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun createViewModel() {
        viewModel = if (useSharedViewModel) {
            ViewModelProvider(requireActivity(), getFactory()).get(getViewModel())
        } else {
            ViewModelProvider(this,getFactory()).get(getViewModel())
        }
    }

    abstract fun init()

    abstract fun getFactory(): ViewModelProvider.Factory
    abstract fun getViewModel(): Class<VM>
}