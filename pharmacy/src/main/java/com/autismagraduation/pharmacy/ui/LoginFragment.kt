package com.autismagraduation.pharmacy.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.autismagraduation.pharmacy.R
import com.autismagraduation.pharmacy.data.ApiClient
import com.autismagraduation.pharmacy.data.LoginRequest
import com.autismagraduation.pharmacy.data.LoginResponse
import com.autismagraduation.pharmacy.databinding.FragmentLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var apiClient: ApiClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        apiClient = ApiClient()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logIn.setOnClickListener {

            checkLogin();

            apiClient.getApiService().login(
                LoginRequest(
                    email,
                    password
                )
            )
                .enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        val loginResponse = response.body()
                        Log.d("Auth", "${loginResponse?.success} + ${loginResponse?.token}");
                        if(loginResponse?.success == true) {
                            Toast.makeText(
                                requireContext(), "Login successfully",
                                Toast.LENGTH_LONG
                            ).show()

                            LoginFinished(loginResponse.token);

                            Navigation.findNavController(requireView()).navigate(
                                R.id.action_loginFragment_to_enterActivity
                            )
                        }
                    }
                    override fun onFailure(call: Call<LoginResponse>,
                                           t: Throwable) {
                        // Error logging in
                        Log.d("Auth", "${t.message}");
                        Toast.makeText(requireContext(), "${t.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })

        }
        binding.Register.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(
                R.id.action_loginFragment_to_registerFragment
            )
        }
        binding.forgetPassword.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(
                R.id.action_loginFragment_to_forgetPasswordFragment
            )
        }
    }

    private fun LoginFinished(userToken: String?){
        val sharedPref = requireActivity().getSharedPreferences(
            "test", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("token", userToken)
        editor.apply()
    }

    private fun checkLogin(): Boolean {
        email = binding.email.editText!!.text.toString()
        password = binding.password.editText!!.text.toString()
        if (email.isEmpty() || password.isEmpty()) {
            if (email.isEmpty()) Toast.makeText(
                requireActivity(), "Please Enter Email",
                Toast.LENGTH_LONG
            ).show()
            if (password.isEmpty()) Toast.makeText(
                requireActivity(), "Please Enter your Password",
                Toast.LENGTH_LONG
            ).show()
        } else return true
        return false
    }

}