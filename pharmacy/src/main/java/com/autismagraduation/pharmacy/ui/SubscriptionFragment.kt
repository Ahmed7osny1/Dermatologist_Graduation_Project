package com.autismagraduation.pharmacy.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.autismagraduation.pharmacy.R
import com.autismagraduation.pharmacy.adapter.SubscribeSliderAdapter
import com.autismagraduation.pharmacy.data.SubscribeData
import com.autismagraduation.pharmacy.databinding.FragmentSubscriptionBinding

class SubscriptionFragment : Fragment() {

    private lateinit var  viewPager2: ViewPager2
    private lateinit var handler : Handler
    private lateinit var imageList:ArrayList<SubscribeData>
    private lateinit var adapter: SubscribeSliderAdapter
    private lateinit var binding: FragmentSubscriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSubscriptionBinding.inflate(inflater,
            container,false)

        init()
        setUpTransformer()

        viewPager2.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.subscribe.setOnClickListener {
            Toast.makeText(requireContext(),
                "${viewPager2.currentItem }",
                Toast.LENGTH_LONG).show()
        }

    }

    override fun onPause() {
        super.onPause()

        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()

        handler.postDelayed(runnable , 2000)
    }

    private val runnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }

    private fun setUpTransformer(){
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - kotlin.math.abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }

        viewPager2.setPageTransformer(transformer)
    }

    private fun init(){
        viewPager2 = binding.viewPager2
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()

        imageList.add(
            SubscribeData(
                R.drawable.acrom,
                "First Type",
                "the good first type"
            )
        )
        imageList.add(
            SubscribeData(
                R.drawable.brownleather,
                "Second Type",
                "the good second type"
            )
        )
        imageList.add(
            SubscribeData(
                R.drawable.pngegg,
                "Third Type",
                "the good third type"
            )
        )

        adapter = SubscribeSliderAdapter(imageList)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER

    }

}