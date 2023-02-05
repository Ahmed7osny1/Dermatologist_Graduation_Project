package com.autismagraduation.dermatologist.ui.appscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.autismagraduation.dermatologist.adapter.DataAdapter
import com.autismagraduation.dermatologist.data.DataUsed
import com.autismagraduation.dermatologist.databinding.FragmentDataBinding
import com.autismagraduation.dermatologist.`object`.SetDataDry
import com.autismagraduation.dermatologist.`object`.SetDataNormal
import com.autismagraduation.dermatologist.`object`.SetDataOil


class DataFragment : Fragment() {

    private lateinit var myArray: ArrayList<DataUsed>
    private lateinit var binding: FragmentDataBinding
    private val args :DataFragmentArgs by this.navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDataBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.dataRecycleView.layoutManager = StaggeredGridLayoutManager(2,
            LinearLayoutManager.VERTICAL)

        getData()

    }

    private fun getData() {

        myArray = arrayListOf()

        val myData = args.skinType
        myArray = when (myData) {
            1 -> {
                SetDataNormal.getNormalData()
            }
            2 -> {
                SetDataDry.getDryData()
            }
            3 -> {
                SetDataOil.getOilData()
            }
            else -> {
                SetDataNormal.getNormalData()
            }
        }

        /*
//sensitive skin

        myArray.add(
            DataUsed(
                R.drawable.biored,
                "BIODERAM",
                "Bioderma Sensibo H2O Micellar Water Makeup Remover ",
                "\n\nMicellar makeup remover water gently cleanses and removes makeup and impurities from the face and eyes without irritating the skin.\n\n" +
                        "Your skin feels fresh, clean and clear\n\n" +
                        "Free of fragrances and does not cause allergies\n\n" +
                        "How to use :\n" +
                        "Put it on a piece of cotton, then remove makeup from the face and eyes, then dry gently"
            )
        )*/

        val adapter = DataAdapter(myArray)
        binding.dataRecycleView.adapter = adapter

        adapter.setonItemClickListener(object: DataAdapter.onItemClickListener {

            override fun dataAction(position: Int) {
                val action = DataFragmentDirections.actionDataFragmentToDataUsedFragment(
                    myArray[position]
                )
                Navigation.findNavController(requireView()).navigate(action)
            }

        })

    }
}