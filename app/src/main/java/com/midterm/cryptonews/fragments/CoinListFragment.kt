package com.midterm.cryptonews.fragments

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.midterm.cryptonews.bases.BaseFragment
import com.midterm.cryptonews.databinding.FragmentCoinListBinding
import com.midterm.cryptonews.repository.Repository
import com.midterm.cryptonews.viewmodels.CoinListFragmentViewModel
import com.midterm.cryptonews.viewmodels.factories.CoinListFragmentViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CoinListFragment :
    BaseFragment<FragmentCoinListBinding, CoinListFragmentViewModel>(FragmentCoinListBinding::inflate) {

    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference

    override fun init() {
        startObservers()
        setListeners()
    }

    private fun startObservers(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.marketResponse.collect {
                val body = it.body()
                if (it.isSuccessful){
                    binding.tvGetBody.text = body!![0].toString()
                }
                else{
                    Log.d("ReqErr",it.message())
                }
            }
        }
    }
    private fun setListeners(){
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

    override var useViewModelFactory = true

    override fun getFactory(): ViewModelProvider.Factory = CoinListFragmentViewModelFactory(
        Repository()
    )

    override fun getViewModel(): Class<CoinListFragmentViewModel> =
        CoinListFragmentViewModel::class.java
}