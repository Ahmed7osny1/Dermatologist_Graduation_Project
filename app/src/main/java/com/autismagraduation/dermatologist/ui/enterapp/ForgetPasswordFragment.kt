package com.autismagraduation.dermatologist.ui.enterapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.autismagraduation.dermatologist.data.ApiClient
import com.autismagraduation.dermatologist.data.ForgetPasswordRequest
import com.autismagraduation.dermatologist.data.ForgetPasswordResponse
import com.autismagraduation.dermatologist.databinding.FragmentForgetPasswordBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ForgetPasswordFragment : Fragment() {

    private lateinit var binding: FragmentForgetPasswordBinding
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var apiClient: ApiClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentForgetPasswordBinding.inflate(inflater, container, false)
        apiClient = ApiClient()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.send.setOnClickListener {
            updatePassword()

            apiClient.getApiService().forgetPassword(
                ForgetPasswordRequest(
                    email,
                    password
                )
            ).enqueue(object: Callback<ForgetPasswordResponse>{
                override fun onResponse(
                    call: Call<ForgetPasswordResponse>,
                    response: Response<ForgetPasswordResponse>
                ) {
                    val ForgetPasswordResponse = response.body()
                    Toast.makeText(
                        requireContext(), ForgetPasswordResponse?.message,
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onFailure(call: Call<ForgetPasswordResponse>, t: Throwable) {
                    // Error logging in
                    Log.d("Auth", "${t.message}");
                    Toast.makeText(requireContext(), "${t.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }

            })
        }
    }

    private fun updatePassword(): Boolean {

        email = binding.emailTil.editText!!.text.toString()
        password = binding.passwordTil.editText!!.text.toString()

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