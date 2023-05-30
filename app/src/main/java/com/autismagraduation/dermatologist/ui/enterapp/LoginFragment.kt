package com.autismagraduation.dermatologist.ui.enterapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.data.*
import com.autismagraduation.dermatologist.databinding.FragmentLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private lateinit var apiClient: ApiClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        apiClient = ApiClient()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logIn.setOnClickListener {

            apiClient.getApiService().login(
                LoginRequest(
                    "ahmedhosny6688@gmail.com",
                    "12345678"
                )
            )
                .enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        val loginResponse = response.body()
                        Log.d("Auth", "${loginResponse?.login} + ${loginResponse?.token}");
                        Toast.makeText(
                            requireContext(), loginResponse?.token,
                            Toast.LENGTH_LONG
                        ).show()

                        Navigation.findNavController(requireView()).navigate(
                            R.id.action_login_to_enterActivity)
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
                R.id.action_login_to_register)
        }
    }

}