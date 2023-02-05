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

        binding.normal.setOnClickListener {
            val action = SkinTypeFragmentDirections.actionSkinTypeFragmentToSkincareFragment(
                1
            )
            Navigation.findNavController(requireView()).navigate(action)
        }

        binding.dry.setOnClickListener {
            val action = SkinTypeFragmentDirections.actionSkinTypeFragmentToSkincareFragment(
                2
            )
            Navigation.findNavController(requireView()).navigate(action)
        }

        binding.oil.setOnClickListener {
            val action = SkinTypeFragmentDirections.actionSkinTypeFragmentToSkincareFragment(
                3
            )
            Navigation.findNavController(requireView()).navigate(action)
        }

        binding.combination.setOnClickListener {
            val action = SkinTypeFragmentDirections.actionSkinTypeFragmentToSkincareFragment(
                4
            )
            Navigation.findNavController(requireView()).navigate(action)
        }


        return binding.root
    }


}