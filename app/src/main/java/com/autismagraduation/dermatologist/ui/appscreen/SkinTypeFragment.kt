package com.autismagraduation.dermatologist.ui.appscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.databinding.FragmentSkintypeBinding

class SkinTypeFragment : Fragment() {

    private lateinit var binding: FragmentSkintypeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSkintypeBinding.inflate(inflater, container,false)

        binding.diagnose.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(
                R.id.action_skinTypeFragment_to_skincareFragment)
        }

        return binding.root
    }


}