package com.autismagraduation.dermatologist.ui.enterapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.data.ApiClient
import com.autismagraduation.dermatologist.data.RegisterResponse
import com.autismagraduation.dermatologist.data.UserData
import com.autismagraduation.dermatologist.databinding.FragmentRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : Fragment() {

    lateinit var binding: FragmentRegisterBinding
    private lateinit var firstName:String
    private lateinit var lastName: String
    private lateinit var email:String
    private lateinit var password: String
    private lateinit var confirmPassword: String
    private lateinit var phone:String
    private lateinit var address: String
    private lateinit var apiClient: ApiClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        apiClient = ApiClient()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signup.setOnClickListener {

            if(createAccount()) {

                apiClient.getApiService().register(
                    UserData(
                        first_name = firstName,
                        last_name = lastName,
                        email = email,
                        password = password,
                        phone_number = phone,
                        address = address
                    )
                )
                    .enqueue(object : Callback<RegisterResponse> {
                        override fun onResponse(
                            call: Call<RegisterResponse>,
                            response: Response<RegisterResponse>
                        ) {

                            Log.d("Auth", "${response.body()?.success}");
                            Toast.makeText(
                                requireContext(), response.body()?.message,
                                Toast.LENGTH_LONG
                            ).show()
                            if(response.body()?.success == true) {
                                Navigation.findNavController(view).navigate(
                                    R.id.action_register_to_login
                                )
                            }
                        }

                        override fun onFailure(call: Call<RegisterResponse>,
                                               t: Throwable) {
                            // Error logging in
                            Log.d("Auth", "${t.message}");
                            Toast.makeText(requireContext(), "${t.message}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    })
            }
        }

    }

    private fun createAccount(): Boolean {

        firstName = binding.firstname.editText?.text.toString()
        lastName = binding.lastname.editText?.text.toString()
        phone = binding.phonenumber.editText?.text.toString()
        email = binding.email.editText?.text.toString()
        password = binding.password.editText?.text.toString()
        confirmPassword = binding.confirmpassword.editText?.text.toString()
        address = binding.address.editText?.text.toString()

        if (firstName.isEmpty() || lastName.isEmpty() ||
            email.isEmpty() || confirmPassword.isEmpty() || password.length != 8 ||
            phone.length != 11 || address.isEmpty()
        ) {
            if (firstName.isEmpty()) Toast.makeText(
                requireActivity(), "Please Enter First Name",
                Toast.LENGTH_LONG
            ).show()
            if (lastName.isEmpty()) Toast.makeText(
                requireActivity(), "Please Enter Last Name",
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