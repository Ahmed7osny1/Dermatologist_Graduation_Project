package com.autismagraduation.dermatologist.ui.appscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.adapter.DataAdapter
import com.autismagraduation.dermatologist.data.DataUsed
import com.autismagraduation.dermatologist.databinding.FragmentHerbsBinding

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


        binding.herbsRecycleView.layoutManager = StaggeredGridLayoutManager(2,
            LinearLayoutManager.VERTICAL)

        getData()

    }

    private fun getData() {

        myArray = arrayListOf<DataUsed>()

        myArray.add(
            DataUsed(
                R.drawable.pngegg,
                "Mayade",
                "senior",
                "jhhhhh"
            )
        )

        myArray.add(
            DataUsed(
                R.drawable.kiss,
                "Mayade",
                "senior",
                "jjjjjjjjj"
            )
        )


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