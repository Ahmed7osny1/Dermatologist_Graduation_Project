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
                R.drawable.qu,
                "QV Cream",
                "Replenishes dry skin",
                55.5,
            )
        )

        myArray.add(
            MedicineData(
                R.drawable.skular,
                "SKYKUR",
                "Skin Skykur Cream",
                77.75,
            )
        )
        myArray.add(
            MedicineData(
                R.drawable.sosoft,
                "A V O N",
                "Sovesoft Cream",
                33.25,
            )
        )

        myArray.add(
            MedicineData(
                R.drawable.seram,
                "INFINITY ANTI_ACING\n",
                "DAY SERUM",
                210.00,
            )
        )


        myArray.add(
            MedicineData(
                R.drawable.eye,
                "Alejon EYE",
                "Medical concealer",
                175.00,
            )
        )

        myArray.add(
            MedicineData(
                R.drawable.nuxe,
                "Nuxe",
                "Oily skin routine",
                121.25,
            )
        )

        myArray.add(
            MedicineData(
                R.drawable.vichy,
                "VICHY",
                "Vichy Normaderm Phytosolution Double correction",
                99.99,
            )
        )

        myArray.add(
            MedicineData(
                R.drawable.biogreen,
                "BIODERAM",
                "Bioderma Sensibo H2O Micellar Water Makeup Remover",
                63.99,
            )
        )

        val adapter = MedicineAdapter(myArray)
        binding.medicineRecycleView.adapter = adapter

    }

}