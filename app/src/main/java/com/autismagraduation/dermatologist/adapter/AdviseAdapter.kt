package com.autismagraduation.dermatologist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.data.AdviseData
import com.autismagraduation.dermatologist.data.MedicineData

class AdviseAdapter (private var MyList: ArrayList<AdviseData>) :
    RecyclerView.Adapter<AdviseAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.advise_item,
            parent,false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return MyList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val advise = MyList[position]

        holder.img.setImageResource(advise.img)
        holder.title.text = advise.AdviseTitle
        holder.discription.text = advise.AdviseDiscription

    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder (itemView) {

        var img = itemView.findViewById<ImageView>(R.id.advise_img)!!
        var title = itemView.findViewById<TextView>(R.id.advise_title)!!
        var discription = itemView.findViewById<TextView>(R.id.advise_discription)!!

    }
}