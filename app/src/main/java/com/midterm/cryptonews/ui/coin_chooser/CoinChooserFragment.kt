package com.midterm.cryptonews.ui.coin_chooser

import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.*

import com.midterm.cryptonews.databinding.FragmentCoinChooserBinding
import com.midterm.cryptonews.repository.Repository
import com.midterm.cryptonews.ui.base.BaseFragment
import com.midterm.cryptonews.ui.coin_chooser.source.CoinChooserAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CoinChooserFragment : BaseFragment<FragmentCoinChooserBinding,CoinChooserViewModel>(FragmentCoinChooserBinding::inflate){

    private val args by navArgs<CoinChooserFragmentArgs>()
    private lateinit var uid:String

    private lateinit var databaseReference: DatabaseReference
    private lateinit var myCoins: ArrayList<String>
    private lateinit var allCoins: ArrayList<String>

    private lateinit var myCoinAdapter:CoinChooserAdapter
    private lateinit var allCoinAdapter:CoinChooserAdapter
    override fun init() {
        uid = args.uid
        binding.progressBar.visibility = View.VISIBLE
        getUserCoins()
        binding.progressBar.visibility = View.GONE
        listeners()
    }

    private fun getUserCoins(){

        databaseReference =
            FirebaseDatabase.getInstance("https://crypto-news-7945a-default-rtdb.europe-west1.firebasedatabase.app")
                .getReference("users")

        val postListener = object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                @Suppress("UNCHECKED_CAST")
                myCoins =  snapshot.value as ArrayList<String>
                getAllCoins()
            }
            override fun onCancelled(error: DatabaseError) {
            }
        }
        databaseReference.child(uid).child("chosenCoins").addValueEventListener(postListener)
    }

    private fun getAllCoins(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.marketResponse.collect {
                allCoins = it
                // Remove My Coins From All Coins
                for(myCoin in myCoins){
                    if(myCoin in allCoins){
                        allCoins.remove(myCoin)
                    }
                }
                initAdapters()
            }
        }
        viewModel.getCoins(arrayListOf(),"usd")
    }

    private fun initAdapters(){
        myCoinAdapter = CoinChooserAdapter(myCoins, isGreen = true) {name,pos->
            myCoins.remove(name)
            myCoinAdapter.notifyItemRemoved(pos)
            allCoins.add(0,name)
            allCoinAdapter.notifyItemInserted(0)
        }
        allCoinAdapter = CoinChooserAdapter(allCoins, isGreen = false){name,pos->
            allCoins.remove(name)
            allCoinAdapter.notifyItemRemoved(pos)
            myCoins.add(0,name)
            myCoinAdapter.notifyItemInserted(0)
        }

        binding.rvMyCoins.apply {
            layoutManager = GridLayoutManager(requireContext(),3)
            adapter = myCoinAdapter
        }
        binding.rvAvailableCoins.apply {
            layoutManager = GridLayoutManager(requireContext(),3)
            adapter = allCoinAdapter
        }
    }

    private fun listeners(){
        binding.btnSave.setOnClickListener {
            databaseReference =
                FirebaseDatabase.getInstance("https://crypto-news-7945a-default-rtdb.europe-west1.firebasedatabase.app")
                    .getReference("users")
            databaseReference.child(uid).child("chosenCoins").setValue(myCoins).addOnCompleteListener { 
                if(it.isSuccessful){
                    findNavController().navigate(CoinChooserFragmentDirections.actionCoinChooserFragmentToCoinListFragment())
                }else{
                    Snackbar.make(binding.root,"Failed To Update Your Coins",Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

    override var useViewModelFactory: Boolean = true

    override fun getFactory(): ViewModelProvider.Factory = CoinListViewModelFactory(Repository())

    override fun getViewModel(): Class<CoinChooserViewModel> = CoinChooserViewModel::class.java

}