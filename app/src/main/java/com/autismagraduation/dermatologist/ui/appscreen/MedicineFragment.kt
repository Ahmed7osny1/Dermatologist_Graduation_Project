package com.autismagraduation.dermatologist.ui.appscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.adapter.MedicineAdapter
import com.autismagraduation.dermatologist.data.MedicineData
import com.autismagraduation.dermatologist.databinding.FragmentMedicineBinding

class MedicineFragment : Fragment() {

    private lateinit var myArray: ArrayList<MedicineData>
    private lateinit var binding: FragmentMedicineBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMedicineBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.medicineRecycleView.layoutManager = StaggeredGridLayoutManager(2,
            LinearLayoutManager.VERTICAL)

        getData()

    }

    private fun getData() {

        myArray = arrayListOf<MedicineData>()

        myArray.add(
            MedicineData(
                R.drawable.pngegg,
                "Mayade",
                "senior",
                15.5,
            )
        )

        myArray.add(
            MedicineData(
                R.drawable.kiss,
                "Mayade",
                "senior",
                15.5,
            )
        )
        myArray.add(
            MedicineData(
                R.drawable.skincare,
                "Mayade",
                "senior",
                15.5,
            )
        )

        myArray.add(
            MedicineData(
                R.drawable.pngegg,
                "Mayade",
                "senior",
                15.5,
            )
        )


        myArray.add(
            MedicineData(
                R.drawable.skincare,
                "Mayade",
                "senior",
                15.5,
            )
        )

        myArray.add(
            MedicineData(
                R.drawable.kiss,
                "Mayade",
                "senior",
                15.5,
            )
        )

        myArray.add(
            MedicineData(
                R.drawable.skincare,
                "Mayade",
                "senior",
                15.5,
            )
        )

        myArray.add(
            MedicineData(
                R.drawable.kiss,
                "Mayade",
                "senior",
                15.5,
            )
        )

        val adapter = MedicineAdapter(myArray)
        binding.medicineRecycleView.adapter = adapter

    }

}