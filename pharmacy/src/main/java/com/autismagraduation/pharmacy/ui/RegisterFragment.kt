package com.autismagraduation.pharmacy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.autismagraduation.pharmacy.R
import com.autismagraduation.pharmacy.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var name:String
    private lateinit var email:String
    private lateinit var password: String
    private lateinit var confirmPassword: String
    private lateinit var phone:String
    private lateinit var address: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signupIn.setOnClickListener {

            createAccount()

            val action = RegisterFragmentDirections.
            actionRegisterFragmentToUploadRegisterFragment(name, email, password,
                phone, address)

            Navigation.findNavController(view).navigate(action)
        }

    }

        private fun createAccount(): Boolean {

            name = binding.firstname.editText?.text.toString()
            phone = binding.phonenumber.editText?.text.toString()
            email = binding.email.editText?.text.toString()
            password = binding.password.editText?.text.toString()
            confirmPassword = binding.confirmpassword.editText?.text.toString()
            address = binding.address.editText?.text.toString()

            if (name.isEmpty() || email.isEmpty() ||
                confirmPassword.isEmpty() || password.length != 8 ||
                phone.length != 11 || address.isEmpty()
            ) {
                if (name.isEmpty()) Toast.makeText(
                    requireActivity(), "Please Enter First Name",
                    Toast.LENGTH_LONG
                ).show()
                if (phone.length != 11) Toast.makeText(
                    requireActivity(), "Please check your Phone = 11",
                    Toast.LENGTH_LONG
                ).show()
                if (email.isEmpty()) Toast.makeText(
                    requireActivity(), "Please Enter Email",
                    Toast.LENGTH_LONG
                ).show()
                if (password.length != 8) Toast.makeText(
                    requireActivity(), "Please check your Password = 8",
                    Toast.LENGTH_LONG
                ).show()
                if (confirmPassword == password) Toast.makeText(
                    requireActivity(), "Please check your Confirm Password",
                    Toast.LENGTH_LONG
                ).show()
                if (address.isEmpty()) Toast.makeText(
                    requireActivity(), "Please Enter your Address",
                    Toast.LENGTH_LONG
                ).show()
            } else return true
            return false
        }

}