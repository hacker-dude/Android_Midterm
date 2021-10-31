package com.midterm.cryptonews.fragments

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.midterm.cryptonews.R
import com.midterm.cryptonews.bases.BaseFragment
import com.midterm.cryptonews.databinding.FragmentRegisterBinding
import com.midterm.cryptonews.viewmodels.RegisterFragmentViewModel


class RegisterFragment : BaseFragment<FragmentRegisterBinding, RegisterFragmentViewModel>(FragmentRegisterBinding::inflate) {
    private lateinit var auth: FirebaseAuth

    override fun init() {
        auth = Firebase.auth

        val currentUser = auth.currentUser
        if(currentUser != null){
            findNavController().navigate(R.id.action_registerFragment_to_dashboardFragment)
        }

        listeners()
    }

    private fun listeners(){
        binding.btnRegister.setOnClickListener {
            register()
        }
    }

    private fun register(){
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("AUTHEE", "createUserWithEmail:success")
                    val user = auth.currentUser
                    findNavController().navigate(R.id.action_registerFragment_to_dashboardFragment)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.d("AUTHEE", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(requireActivity(), "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    // updateUI(null)
                }
            }
    }

    override fun getFactory(): ViewModelProvider.Factory? = null

    override fun getViewModel(): Class<RegisterFragmentViewModel> = RegisterFragmentViewModel::class.java
}