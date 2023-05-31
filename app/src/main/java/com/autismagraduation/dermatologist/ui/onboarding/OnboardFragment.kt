package com.autismagraduation.dermatologist.ui.onboarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.adapter.ViewPagerAdapter
import com.autismagraduation.dermatologist.data.OnboardingData
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
        binding = FragmentOnboardBinding.inflate(inflater, container,
            false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        tabLayout = binding.tabIndicator

        val onBoardingData: MutableList<OnboardingData> = ArrayList()

        onBoardingData.add(
            OnboardingData(
                R.drawable.sldone,
                getString(R.string.hey),
                getString(R.string.onedesc)
            )
        )

        onBoardingData.add(
            OnboardingData(
                R.drawable.sldtwo,
                getString(R.string.onboardtwo),
                getString(R.string.twodesc)
            )
        )

        onBoardingData.add(
            OnboardingData(
                R.drawable.sldthree,
                getString(R.string.onboardthree),
                getString(R.string.threedesc)
            )
        )
        onBoardingData.add(
            OnboardingData(
                R.drawable.sldfour,
                getString(R.string.onboardfour),
                getString(R.string.fourdesc)
            )
        )
        onBoardingData.add(
            OnboardingData(R.drawable.sldfive,
                getString(R.string.onboardfive),
                getString(R.string.fivedesc)
            )
        )

        onBoardingData.add(
            OnboardingData(R.drawable.sldsix,
                getString(R.string.onboardsix),
                getString(R.string.sixdesc)
            )
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
                    R.id.action_onboardFragment_to_login)
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