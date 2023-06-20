package com.autismagraduation.dermatologist.ui.enterapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.data.ApiClient
import com.autismagraduation.dermatologist.data.UserProfile
import com.autismagraduation.dermatologist.databinding.FragmentProfileBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileFragment : Fragment() {

    private  lateinit var binding: FragmentProfileBinding
    private lateinit var apiClient: ApiClient


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        apiClient = ApiClient()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = requireActivity().getSharedPreferences(
            "test", Context.MODE_PRIVATE)

        binding.backBtnProfile.setOnClickListener {
            Navigation.findNavController(view).navigate(
                R.id.action_profileFragment_to_homeFragment)
        }

        apiClient.getApiService().getUserProfile(
            token = "${sharedPref.getString("token",null)}").
        enqueue(object: Callback<UserProfile> {
            override fun onResponse(call: Call<UserProfile>, response: Response<UserProfile>) {
                val profileResponse = response.body()
                Log.d("Auth", "${profileResponse?.success}")

                if (profileResponse?.success == true){
                    ("${profileResponse.data.first_name} " +
                            profileResponse.data.last_name).also { binding.yourName.text = it }
                    binding.yourEmail.text = profileResponse.data.email
                    binding.yourAddress.text = profileResponse.data.address
                    binding.yourPhone.text = profileResponse.data.phone_number
                }

            }

            override fun onFailure(call: Call<UserProfile>, t: Throwable) {
                // Error logging in
                Log.d("Auth", "${t.message}");
                Toast.makeText(requireContext(), "${t.message}",
                    Toast.LENGTH_LONG
                ).show()
            }

        })
    }

}