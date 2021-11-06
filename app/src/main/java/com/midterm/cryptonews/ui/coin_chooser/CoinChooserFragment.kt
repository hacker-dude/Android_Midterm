package com.midterm.cryptonews.ui.coin_chooser


import androidx.lifecycle.ViewModelProvider
import com.midterm.cryptonews.databinding.FragmentCoinChooserBinding
import com.midterm.cryptonews.ui.base.BaseFragment

class CoinChooserFragment : BaseFragment<FragmentCoinChooserBinding,CoinChooserViewModel>(FragmentCoinChooserBinding::inflate) {
    override fun init() {
    }
    override fun getFactory(): ViewModelProvider.Factory? = null

    override fun getViewModel(): Class<CoinChooserViewModel> = CoinChooserViewModel::class.java

}