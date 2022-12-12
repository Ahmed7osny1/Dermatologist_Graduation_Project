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
                R.drawable.pngegg,
                "skincare",
                "semi senior",
                15.5,
                10.5
            )
        )

        myArray.add(
            OfferData(
                R.drawable.kiss,
                "skincare",
                "semi senior",
                15.5,
                10.5
            )
        )
        myArray.add(
            OfferData(
                R.drawable.skincare,
                "skincare",
                "semi senior",
                600.99,
                500.99
            )
        )

        myArray.add(
            OfferData(
                R.drawable.pngegg,
                "skincare",
                "semi senior",
                15.5,
                10.5
            )
        )


        myArray.add(
            OfferData(
                R.drawable.skincare,
                "skincare",
                "semi senior",
                15.5,
                10.5
            )
        )

        myArray.add(
            OfferData(
                R.drawable.kiss,
                "skincare",
                "semi senior",
                600.99,
                500.99
            )
        )

        myArray.add(
            OfferData(
                R.drawable.skincare,
                "skincare",
                "semi senior",
                15.5,
                10.5
            )
        )

        myArray.add(
            OfferData(
                R.drawable.kiss,
                "skincare",
                "semi senior",
                600.5,
                480.5
            )
        )

        val adapter = OfferAdapter(myArray)
        binding.offerRecycleView.adapter = adapter

    }


}