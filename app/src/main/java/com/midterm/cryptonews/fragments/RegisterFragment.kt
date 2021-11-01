package com.midterm.cryptonews.fragments

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.midterm.cryptonews.R
import com.midterm.cryptonews.bases.BaseFragment
import com.midterm.cryptonews.databinding.FragmentRegisterBinding
import com.midterm.cryptonews.enums.ErrorHandlerMessages
import com.midterm.cryptonews.extensions.isAlphaNumeric
import com.midterm.cryptonews.extensions.setReadOnly
import com.midterm.cryptonews.user.User
import com.midterm.cryptonews.viewmodels.RegisterFragmentViewModel


class RegisterFragment :
    BaseFragment<FragmentRegisterBinding, RegisterFragmentViewModel>(FragmentRegisterBinding::inflate) {
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference

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
            binding.pbRegistering.visibility = View.VISIBLE

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        Log.d("AuthLogger", "createUserWithEmail:success")

                        val user = auth.currentUser
                        val uid = user!!.uid

                        // I SHOULDN'T HAVE TO DO THIS BY HAND
                        databaseReference =
                            FirebaseDatabase.getInstance("https://crypto-news-7945a-default-rtdb.europe-west1.firebasedatabase.app")
                                .getReference("users")

                        val userDB = User(username, arrayListOf("USD", "RUB", "EUR"))

                        databaseReference.child(uid).setValue(userDB).addOnCompleteListener {
                            if (it.isSuccessful) {
                                Log.d("AuthLogger", "inside database reference", it.exception)
                                disableForTransition()
                                binding.pbRegistering.visibility = View.GONE
                                findNavController().navigate(R.id.action_registerFragment_to_dashboardFragment)
                            } else {
                                Log.d("AuthLogger", "createUserWithEmail:failure", it.exception)
                                Snackbar.make(
                                    binding.root,
                                    "Failed To Store Username",
                                    Snackbar.LENGTH_LONG
                                ).show()
                            }
                        }
                    } else {
                        Log.d("AuthLogger", "createUserWithEmail:failure", task.exception)
                        if (task.exception is FirebaseAuthUserCollisionException) {
                            emailField.error = ErrorHandlerMessages.EMAIL_ALREADY_IN_USE.message
                        } else {
                            Snackbar.make(
                                binding.root,
                                ErrorHandlerMessages.AUTH_FAILED.message,
                                Snackbar.LENGTH_LONG
                            ).show()
                        }
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
            } else {
                passwordField.error = null
            }
        }

        if (result) passwordField.error = null

        if (username.isEmpty()) {
            usernameField.error = ErrorHandlerMessages.THIS_FIELD_IS_REQUIRED.message
            result = false
        } else {
            if (!username.isAlphaNumeric()) {
                usernameField.error = ErrorHandlerMessages.INVALID_CHARS_USERNAME.message
            } else {
                usernameField.error = null
            }
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

    private fun disableForTransition() {
        email.setReadOnly(true)
        password.setReadOnly(true)
        username.setReadOnly(true)
        binding.btnRegister.isClickable = false
    }

    override fun getFactory(): ViewModelProvider.Factory? = null

    override fun getViewModel(): Class<RegisterFragmentViewModel> =
        RegisterFragmentViewModel::class.java
}