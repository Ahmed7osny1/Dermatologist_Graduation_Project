package com.autismagraduation.dermatologist.ui.appscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.adapter.AdviseAdapter
import com.autismagraduation.dermatologist.adapter.MedicineAdapter
import com.autismagraduation.dermatologist.data.AdviseData
import com.autismagraduation.dermatologist.data.MedicineData
import com.autismagraduation.dermatologist.databinding.FragmentHerbsBinding
import com.autismagraduation.dermatologist.databinding.FragmentMedicineBinding
import com.autismagraduation.dermatologist.databinding.FragmentSkincareBinding

class HerbsFragment : Fragment() {

    private lateinit var myArray: ArrayList<AdviseData>
    private lateinit var binding: FragmentHerbsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHerbsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.herbsRecycleView.layoutManager = StaggeredGridLayoutManager(2,
            LinearLayoutManager.VERTICAL)

        getData()

    }

    private fun getData() {

        myArray = arrayListOf<AdviseData>()

        myArray.add(
            AdviseData(
                R.drawable.pngegg,
                "Mayade",
                "senior",
            )
        )

        myArray.add(
            AdviseData(
                R.drawable.kiss,
                "Mayade",
                "senior",
            )
        )
        myArray.add(
            AdviseData(
                R.drawable.skincare,
                "Mayade",
                "senior",
            )
        )

        myArray.add(
            AdviseData(
                R.drawable.pngegg,
                "Mayade",
                "senior",
            )
        )


        myArray.add(
            AdviseData(
                R.drawable.skincare,
                "Mayade",
                "senior",
            )
        )

        myArray.add(
            AdviseData(
                R.drawable.kiss,
                "Mayade",
                "senior",
            )
        )

        myArray.add(
            AdviseData(
                R.drawable.skincare,
                "Mayade",
                "senior",
            )
        )

        myArray.add(
            AdviseData(
                R.drawable.kiss,
                "Mayade",
                "senior",
            )
        )

        val adapter = AdviseAdapter(myArray)
        binding.herbsRecycleView.adapter = adapter

    }
}