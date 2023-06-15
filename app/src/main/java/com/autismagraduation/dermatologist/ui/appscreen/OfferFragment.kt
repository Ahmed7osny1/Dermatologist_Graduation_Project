package com.autismagraduation.dermatologist.ui.appscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.adapter.OfferAdapter
import com.autismagraduation.dermatologist.data.OfferData
import com.autismagraduation.dermatologist.databinding.FragmentOfferBinding

class OfferFragment : Fragment() {

    private lateinit var myArray: ArrayList<OfferData>
    private lateinit var binding: FragmentOfferBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOfferBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.offerRecycleView.layoutManager = StaggeredGridLayoutManager(2,
            LinearLayoutManager.VERTICAL)

        getData()

    }

    private fun getData() {

        myArray = arrayListOf<OfferData>()

        myArray.add(
            OfferData(
                R.drawable.hyalu,
                "HYALU COLLAGEN",
                "Eye Cream",
                155.5,
                133.5
            )
        )

        myArray.add(
            OfferData(
                R.drawable.maskara,
                "Ecrinal",
                "Eyelash strengthener",
                99.99,
                87.50
            )
        )
        myArray.add(
            OfferData(
                R.drawable.dna,
                "DNA",
                "RADIANCE EYE CONTOUR",
                600.25,
                500.99
            )
        )

        myArray.add(
            OfferData(
                R.drawable.bodyalogen,
                "Alejon Body lotion",
                "Body lotion",
                323.00,
                297.75
            )
        )


        myArray.add(
            OfferData(
                R.drawable.nails,
                "ECRINAL",
                "Vitamin Nail Strengthener",
                111.00,
                99.75
            )
        )

        myArray.add(
            OfferData(
                R.drawable.urepar,
                "UREPAR",
                "Foot_Cream",
                80.00,
                65.00
            )
        )

        myArray.add(
            OfferData(
                R.drawable.soothing,
                "Soothing Gel",
                "Allontion and Vitamin E",
                114.5,
                98.5
            )
        )

        myArray.add(
            OfferData(
                R.drawable.carwhite,
                "CARO WHITE",
                "Creme De Beaute Eclaircissante",
                58.5,
                44.5
            )
        )

        val adapter = OfferAdapter(myArray)
        binding.offerRecycleView.adapter = adapter

    }


}