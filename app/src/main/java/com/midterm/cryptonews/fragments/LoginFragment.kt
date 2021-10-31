package com.midterm.cryptonews.fragments


import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.midterm.cryptonews.R
import com.midterm.cryptonews.bases.BaseFragment
import com.midterm.cryptonews.databinding.FragmentLoginBinding
import com.midterm.cryptonews.enums.ErrorHandlerMessages
import com.midterm.cryptonews.viewmodels.LoginFragmentViewModel

class LoginFragment :
    BaseFragment<FragmentLoginBinding, LoginFragmentViewModel>(FragmentLoginBinding::inflate) {

    private lateinit var auth: FirebaseAuth

    private lateinit var emailField: TextInputLayout
    private lateinit var passwordField: TextInputLayout

    private lateinit var email: TextInputEditText
    private lateinit var password: TextInputEditText

    override fun init() {

        auth = Firebase.auth

        val currentUser = auth.currentUser
        if (currentUser != null) {
            findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
        }

        setViews()

        listeners()
    }

    private fun listeners() {
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {

        val email = email.text.toString()
        val password = password.text.toString()


        val checkInputs = checkForValidity(email, password)

        if (checkInputs) {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("AUTHEE", "signInWithEmail:success")
                        val user = auth.currentUser // NEED TO DO SOMETHING WITH THIS
                        findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
                    } else {

                        Log.d("AUTHEE", "signInWithEmail:failure", task.exception)

                        // -------------------------------------------------

                        if (task.exception is FirebaseAuthInvalidUserException) {

                            val errorMessage =
                                (task.exception as FirebaseAuthInvalidUserException).errorCode

                            if (errorMessage == "ERROR_USER_NOT_FOUND") {
                                emailField.error =
                                    ErrorHandlerMessages.USER_WITH_THIS_EMAIL_DOES_NOT_EXIST.message
                            }
                            // ....
                        }

                        if (task.exception is FirebaseAuthInvalidCredentialsException) {
                            passwordField.error = ErrorHandlerMessages.INVALID_PASSWORD.message
                            // ....
                        }
                    }
                }
        }
    }

    private fun checkForValidity(email: String, password: String): Boolean {

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
            passwordField.error = null
        }

        return result
    }

    private fun setViews() {
        emailField = binding.ilEmail
        passwordField = binding.ilPassword
        email = binding.etEmail
        password = binding.etPassword
    }

    override fun getFactory(): ViewModelProvider.Factory? = null
    override fun getViewModel(): Class<LoginFragmentViewModel> = LoginFragmentViewModel::class.java
}