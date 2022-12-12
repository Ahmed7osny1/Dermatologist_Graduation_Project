package com.autismagraduation.dermatologist.ui.appscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.diagnose.checkDiagnose.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(
                R.id.action_homeFragment_to_model
            )
        }

        binding.medicineMenu.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(
                R.id.action_homeFragment_to_medicineFragment)
        }

        binding.herbsMenu.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(
                R.id.action_homeFragment_to_herbsFragment)
        }

        binding.skincareMenu.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(
                R.id.action_homeFragment_to_skintypeFragment)
        }

    }
}