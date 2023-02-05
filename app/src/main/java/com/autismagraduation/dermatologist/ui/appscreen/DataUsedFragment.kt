package com.autismagraduation.dermatologist.ui.appscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.autismagraduation.dermatologist.databinding.FragmentDatausedBinding

class DataUsedFragment : Fragment() {

    private var binding: FragmentDatausedBinding? = null
    private val args :DataUsedFragmentArgs by this.navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDatausedBinding.inflate(inflater, container, false)

        val myData = args.dataused

        binding!!.dataImage.setImageResource(myData.img)
        binding!!.dataTitle.text = myData.AdviseTitle
        binding!!.dataDescription.text = myData.AdviseDiscription
        binding!!.dataUesd.text = myData.AdviseUse

        return binding!!.root
    }


}
