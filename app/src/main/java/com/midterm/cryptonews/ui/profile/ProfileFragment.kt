package com.midterm.cryptonews.ui.profile

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.midterm.cryptonews.R
import com.midterm.cryptonews.databinding.FragmentProfileBinding
import com.midterm.cryptonews.enums.Project
import com.midterm.cryptonews.ui.base.BaseFragment
import java.lang.Exception


class ProfileFragment : BaseFragment<FragmentProfileBinding,ProfileViewModel>(FragmentProfileBinding::inflate) {
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference

    override fun init() {
        getUserName()
        listeners()
        getVersion()
    }

    private fun listeners(){
        binding.btnLogOut.setOnClickListener {
            logOut()
            findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
        }
        binding.btnGitPage.setOnClickListener {
            goToGit()
        }
    }
    private fun goToGit(){
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(Project.SOURCE_LINK.message))
        startActivity(browserIntent)
    }
    private fun logOut(){
        auth.signOut()
    }
    private fun getVersion(){
        try {
            val info = requireContext().packageManager.getPackageInfo(requireContext().packageName,0)
            binding.tvVersion.text = "V ".plus(info.versionName)
        }catch (e : Exception){
            Snackbar.make(binding.root,"Unable To Open Page",Snackbar.LENGTH_LONG).show()
        }
    }
    private fun getUserName(){
        auth = Firebase.auth
        val uid = auth.currentUser!!.uid

        databaseReference =
            FirebaseDatabase.getInstance("https://crypto-news-7945a-default-rtdb.europe-west1.firebasedatabase.app")
                .getReference("users")

        val postListener = object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val post = snapshot.value as String
                binding.tvUserName.text = post
            }
            override fun onCancelled(error: DatabaseError) {
                Snackbar.make(binding.root,"Unable To Load User",Snackbar.LENGTH_LONG).show()
            }
        }
        databaseReference.child(uid).child("username").addValueEventListener(postListener)

    }

    override fun getFactory(): ViewModelProvider.Factory? = null

    override fun getViewModel(): Class<ProfileViewModel> = ProfileViewModel::class.java

}