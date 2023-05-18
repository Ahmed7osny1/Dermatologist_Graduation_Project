package com.autismagraduation.pharmacy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.autismagraduation.pharmacy.databinding.FragmentHomeBinding
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel

class homeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        imageSliderSetup()

        return binding.root
    }

    private fun imageSliderSetup(){

        val imageList = ArrayList<SlideModel>()

        imageList.add(
            SlideModel(
                R.drawable.acrom,
            "The animal population decreased by 58",
                ScaleTypes.FIT
            )
        )
        imageList.add(
            SlideModel(
                R.drawable.logo,
            "Elephants and tigers may become extinct.",
                ScaleTypes.FIT
            )
        )
        imageList.add(
            SlideModel(
                R.drawable.pngegg,
            "And people do that.",
                ScaleTypes.FIT
            )
        )

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)

    }

}