package com.midterm.cryptonews.ui.coin_list

import android.util.Log
import android.view.View
import com.midterm.cryptonews.R
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.midterm.cryptonews.databinding.FragmentCoinListBinding
import com.midterm.cryptonews.models.MoshiMarketModel
import com.midterm.cryptonews.repository.Repository
import com.midterm.cryptonews.ui.base.BaseFragment
import com.midterm.cryptonews.ui.coin_list.source.CoinsAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CoinListFragment :
    BaseFragment<FragmentCoinListBinding, CoinListViewModel>(FragmentCoinListBinding::inflate) {

    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var coins: Array<MoshiMarketModel>

    override fun init() {
        // FIX
        binding.progressBar.visibility = View.VISIBLE
        binding.btnAdd.isClickable = false
        startObservers()
        setListeners()
    }

    private fun startObservers(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.marketResponse.collect {
                val body = it.body()
                if (it.isSuccessful){
                    coins = body!!
                    initAdapter()
                    // FIX
                    binding.progressBar.visibility = View.GONE
                    binding.btnAdd.isClickable = true
                }
                else{
                    Log.d("ReqErr",it.message())
                }
            }
        }
    }
    private fun setListeners(){

        binding.btnAdd.setOnClickListener {
            goToCoinChooser()
        }

        auth = Firebase.auth
        val uid = auth.uid

        databaseReference =
            FirebaseDatabase.getInstance("https://crypto-news-7945a-default-rtdb.europe-west1.firebasedatabase.app")
                .getReference("users")

        val postListener = object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                @Suppress("UNCHECKED_CAST")
                val post = snapshot.value as ArrayList<String>
                viewModel.getCoins(post,"usd")
                // binding.tvGetBody.text = post.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d( "ValueUpdateError","line 58 log value not updated")
            }
        }
        databaseReference.child(uid!!).child("chosenCoins").addValueEventListener(postListener)
    }

    private fun initAdapter(){
        binding.rvCoinList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CoinsAdapter(coins)
        }
    }

    private fun goToCoinChooser(){
        findNavController().navigate(R.id.action_coinListFragment_to_coinChooserFragment)
    }

    override var useViewModelFactory = true

    override fun getFactory(): ViewModelProvider.Factory = CoinListViewModelFactory(Repository())

    override fun getViewModel(): Class<CoinListViewModel> =
        CoinListViewModel::class.java
}