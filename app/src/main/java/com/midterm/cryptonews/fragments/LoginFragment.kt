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
import com.midterm.cryptonews.databinding.FragmentLoginBinding
import com.midterm.cryptonews.viewmodels.LoginFragmentViewModel

class LoginFragment : BaseFragment<FragmentLoginBinding,LoginFragmentViewModel>(FragmentLoginBinding::inflate) {

    private lateinit var auth: FirebaseAuth

    override fun init() {
        auth = Firebase.auth

        val currentUser = auth.currentUser
        if(currentUser != null){
            findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
        }



        listeners()
    }
    private fun listeners(){
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnLogin.setOnClickListener {
            login()
        }
    }
    private fun login(){
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("AUTHEE", "signInWithEmail:success")
                    val user = auth.currentUser
                    findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.d("AUTHEE", "signInWithEmail:failure", task.exception)
                    Toast.makeText(requireActivity(), "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    // updateUI(null)
                }
            }
    }

    override fun getFactory(): ViewModelProvider.Factory? = null
    override fun getViewModel(): Class<LoginFragmentViewModel> = LoginFragmentViewModel::class.java
}