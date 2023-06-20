package com.autismagraduation.dermatologist.ui.appscreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.adapter.MedicineAdapter
import com.autismagraduation.dermatologist.adapter.OfferAdapter
import com.autismagraduation.dermatologist.data.ApiClient
import com.autismagraduation.dermatologist.data.DataX
import com.autismagraduation.dermatologist.data.MedicineData
import com.autismagraduation.dermatologist.data.MedicineDataX
import com.autismagraduation.dermatologist.databinding.FragmentMedicineBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MedicineFragment : Fragment() {

    private lateinit var myArray: ArrayList<DataX>
    private lateinit var binding: FragmentMedicineBinding
    private lateinit var apiClient: ApiClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMedicineBinding.inflate(inflater, container, false)
        apiClient = ApiClient()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.medicineRecycleView.layoutManager = StaggeredGridLayoutManager(
            2,
            LinearLayoutManager.VERTICAL
        )

        getData()

    }

    private fun getData() {

        myArray = arrayListOf<DataX>()

        apiClient.getApiService().getMedicine().enqueue(object : Callback<MedicineDataX> {
            override fun onResponse(call: Call<MedicineDataX>, response: Response<MedicineDataX>) {

                val medicineResponse = response.body()

                Log.d("Auth", "${medicineResponse?.success} + ${medicineResponse?.data}")

                if (medicineResponse != null) {
                    myArray.addAll(medicineResponse.data)
                }
                Log.d("Auth", "${myArray}")

                val adapter = MedicineAdapter(myArray)
                binding.medicineRecycleView.adapter = adapter

                adapter.setonItemClickListener(object : MedicineAdapter.onItemClickListener {
                    override fun bookAction(position: Int) {
                        Toast.makeText(requireContext(), "$position", Toast.LENGTH_LONG).show()
                    }

                })

            }

            override fun onFailure(call: Call<MedicineDataX>, t: Throwable) {
                // Error logging in
                Log.d("Auth", "${t.message}");
                Toast.makeText(
                    requireContext(), "${t.message}",
                    Toast.LENGTH_LONG
                ).show()
            }

        })
    }
}