package com.autismagraduation.pharmacy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.autismagraduation.pharmacy.R
import com.autismagraduation.pharmacy.data.SubscribeData

class SubscribeSliderAdapter(private val imageList: ArrayList<SubscribeData>) :
    RecyclerView.Adapter<SubscribeSliderAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.subscribe_container,
                parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.imageView.setImageResource(imageList[position].img)
        holder.title.text = imageList[position].title
        holder.desc.text = imageList[position].description
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val title: TextView = itemView.findViewById(R.id.title)
        val desc: TextView = itemView.findViewById(R.id.description)
    }


}