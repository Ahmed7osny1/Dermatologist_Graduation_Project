package com.autismagraduation.pharmacy.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.autismagraduation.pharmacy.R
import com.autismagraduation.pharmacy.adapter.ViewPagerAdapter
import com.autismagraduation.pharmacy.data.OnboardingData
import com.autismagraduation.pharmacy.databinding.FragmentOnboardingBinding
import com.google.android.material.tabs.TabLayout


class OnboardingFragment : Fragment() {

    private lateinit var onboardingViewPagerAdapter: ViewPagerAdapter
    private lateinit var tabLayout: TabLayout
    private lateinit var onboardingViewPager: ViewPager
    private var position: Int = 0
    private lateinit var binding: FragmentOnboardingBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnboardingBinding.inflate(inflater, container,
            false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        tabLayout = binding.tabIndicator

        val onBoardingData: MutableList<OnboardingData> = ArrayList()

        onBoardingData.add(
            OnboardingData(
                R.drawable.logo,"hey",
                "Easy to post your job offer to job seekers")
        )
        onBoardingData.add(
            OnboardingData(
                R.drawable.logo,"hello",
                "Easy to post your job offer to job seekers")
        )
        onBoardingData.add(
            OnboardingData(
                R.drawable.logo,"hi",
                "Easy to post your job offer to job seekers")
        )

        setOnboardingViewPager(onBoardingData)

        position = onboardingViewPager.currentItem

        val next = binding.button

        next.setOnClickListener {
            if (position < onBoardingData.size){
                position++
                onboardingViewPager.currentItem = position
            }
            if(position == onboardingViewPager.size + 1){
                onBoardingFinished()
                findNavController().navigate(
                    R.id.action_onboardingFragment_to_loginFragment
                )
            }

        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                position = tab.position
                if (tab.position == 2) {
                    next.text = "Get Started"
                } else {
                    next.text = "Next"
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding",
            Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

    private fun setOnboardingViewPager(onboardingData: List<OnboardingData>){

        onboardingViewPager = binding.screenPager
        onboardingViewPagerAdapter = ViewPagerAdapter(requireContext(), onboardingData)
        onboardingViewPager.adapter = onboardingViewPagerAdapter
        tabLayout.setupWithViewPager(onboardingViewPager)
    }

}