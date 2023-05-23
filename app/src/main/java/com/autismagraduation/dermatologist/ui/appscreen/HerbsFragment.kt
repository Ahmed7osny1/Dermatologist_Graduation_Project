package com.autismagraduation.dermatologist.ui.appscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.autismagraduation.dermatologist.adapter.DataAdapter
import com.autismagraduation.dermatologist.data.DataUsed
import com.autismagraduation.dermatologist.databinding.FragmentHerbsBinding
import com.autismagraduation.dermatologist.`object`.SetDataHerbs

class HerbsFragment : Fragment() {

    private lateinit var myArray: ArrayList<DataUsed>
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


        binding.herbsRecycleView.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,false)

        getData()

    }

    private fun getData() {

        myArray = arrayListOf<DataUsed>()

        myArray = SetDataHerbs.getDataHerbs()


        val adapter = DataAdapter(myArray)
        binding.herbsRecycleView.adapter = adapter

        adapter.setonItemClickListener(object: DataAdapter.onItemClickListener {

            override fun dataAction(position: Int) {
                val action = HerbsFragmentDirections.actionHerbsFragmentToDataUsedFragment(
                    myArray[position]
                )
                Navigation.findNavController(requireView()).navigate(action)
            }

        })

    }
}