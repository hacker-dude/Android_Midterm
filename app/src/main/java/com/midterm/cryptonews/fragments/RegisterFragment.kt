package com.midterm.cryptonews.fragments

import android.util.Log
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.midterm.cryptonews.R
import com.midterm.cryptonews.bases.BaseFragment
import com.midterm.cryptonews.databinding.FragmentRegisterBinding
import com.midterm.cryptonews.enums.ErrorHandlerMessages
import com.midterm.cryptonews.viewmodels.RegisterFragmentViewModel


class RegisterFragment :
    BaseFragment<FragmentRegisterBinding, RegisterFragmentViewModel>(FragmentRegisterBinding::inflate) {
    private lateinit var auth: FirebaseAuth

    private lateinit var emailField: TextInputLayout
    private lateinit var passwordField: TextInputLayout
    private lateinit var usernameField: TextInputLayout

    private lateinit var email: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var username: TextInputEditText


    override fun init() {
        auth = Firebase.auth

        val currentUser = auth.currentUser
        if (currentUser != null) {
            findNavController().navigate(R.id.action_registerFragment_to_dashboardFragment)
        }

        setViews()

        listeners()
    }

    private fun listeners() {
        binding.btnRegister.setOnClickListener {
            register()
        }
    }

    private fun register() {
        val email = email.text.toString()
        val password = password.text.toString()
        val username = username.text.toString()


        val checkInputs = checkForValidity(email, password, username)

        if (checkInputs) {
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
                        Toast.makeText(
                            requireActivity(), "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                        // updateUI(null)
                    }
                }
        }
    }

    private fun checkForValidity(email: String, password: String, username: String): Boolean {

        var result = true

        if (email.isNotEmpty()) {
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailField.error = ErrorHandlerMessages.INVALID_EMAIL_FORMAT.message
                result = false
            }
        } else {
            emailField.error = ErrorHandlerMessages.THIS_FIELD_IS_REQUIRED.message
            result = false
        }

        if (result) emailField.error = null

        if (password.isEmpty()) {
            passwordField.error = ErrorHandlerMessages.THIS_FIELD_IS_REQUIRED.message
            result = false
        } else {
            if (password.length < 6) {
                passwordField.error = ErrorHandlerMessages.PASSWORD_TOO_SHORT.message
                result = false
            }
            passwordField.error = null
        }

        if (result) passwordField.error = null

        if (username.isEmpty()) {
            usernameField.error = ErrorHandlerMessages.THIS_FIELD_IS_REQUIRED.message
            result = false
        } else {
            usernameField.error = null
        }

        return result
    }

    private fun setViews() {
        emailField = binding.ilEmail
        passwordField = binding.ilPassword
        usernameField = binding.ilUserName
        email = binding.etEmail
        password = binding.etPassword
        username = binding.etUserName
    }

    override fun getFactory(): ViewModelProvider.Factory? = null

    override fun getViewModel(): Class<RegisterFragmentViewModel> =
        RegisterFragmentViewModel::class.java
}