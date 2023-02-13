package com.autismagraduation.dermatologist.ui.onboarding

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.size
import androidx.navigation.Navigation
import androidx.viewpager.widget.ViewPager
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.adapter.ViewPagerAdapter
import com.autismagraduation.dermatologist.data.OnboardingData
import com.autismagraduation.dermatologist.databinding.FragmentDataBinding
import com.autismagraduation.dermatologist.databinding.FragmentOnboardBinding
import com.google.android.material.tabs.TabLayout


class OnboardFragment : Fragment() {

    private lateinit var onboardingViewPagerAdapter: ViewPagerAdapter
    private lateinit var tabLayout: TabLayout
    private lateinit var onboardingViewPager: ViewPager
    private var position: Int = 0
    private lateinit var binding: FragmentOnboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOnboardBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        tabLayout = binding.tabIndicator

        val onBoardingData: MutableList<OnboardingData> = ArrayList()

        onBoardingData.add(
            OnboardingData(R.drawable.acrom,"hey","Easy to post your job offer to job seekers")
        )
        onBoardingData.add(
            OnboardingData(R.drawable.atoderm,"hello","Easy to post your job offer to job seekers")
        )
        onBoardingData.add(
            OnboardingData(R.drawable.biored,"hi","Easy to post your job offer to job seekers")
        )

        setOnboardingViewPager(onBoardingData)

        position = onboardingViewPager.currentItem

        val next = binding.button

        next.setOnClickListener {
            if (position < onBoardingData.size){
                position++
                onboardingViewPager.currentItem = position
            }
            if(position == onboardingViewPager.size){
                savePrefData()
                Navigation.findNavController(requireView()).navigate(
                    R.id.action_onboardFragment_to_login)
            }

        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                position = tab.position
                if (tab.position == onboardingViewPager.size - 1) {
                    next.text = "Get Started"
                } else {
                    next.text = "Next"
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun restorePref(): Boolean {
        val sharedPreferences = requireActivity().getSharedPreferences("mypref",
            AppCompatActivity.MODE_PRIVATE
        )
        return sharedPreferences.getBoolean("isFristTimeLaunch", false)
    }

    private fun savePrefData() {

        val sharedPreferences: SharedPreferences =   requireActivity().getSharedPreferences(
            "mypref", AppCompatActivity.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putBoolean("isFristTimeLaunch", true)
        editor.apply()

    }

    private fun setOnboardingViewPager(onboardingData: List<OnboardingData>){

        onboardingViewPager = binding.screenPager
        onboardingViewPagerAdapter = ViewPagerAdapter(requireContext(), onboardingData)
        onboardingViewPager.adapter = onboardingViewPagerAdapter
        tabLayout.setupWithViewPager(onboardingViewPager)
    }

}