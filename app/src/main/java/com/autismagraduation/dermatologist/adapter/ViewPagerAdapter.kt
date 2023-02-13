package com.autismagraduation.dermatologist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.data.OnboardingData


class ViewPagerAdapter (private val context: Context,
                        private val OnboardingList: List<OnboardingData>): PagerAdapter(){

    override fun getCount(): Int {
        return OnboardingList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view: View = LayoutInflater.from(context).inflate(
            R.layout.intro_screen_layout,
            null
        )

        val image: ImageView = view.findViewById(R.id.imageView)
        val title: TextView = view.findViewById(R.id.title)
        val desc: TextView = view.findViewById(R.id.desc)


        image.setImageResource(OnboardingList[position].image)
        title.text = OnboardingList[position].title
        desc.text = OnboardingList[position].desc
        container.addView(view)
        return view

    }
}