package com.autismagraduation.dermatologist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.data.DataUsed
import kotlinx.android.synthetic.main.advise_item.view.*

class DataAdapter (private var MyList: ArrayList<DataUsed>) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {

        fun dataAction(position: Int)
    }

    fun setonItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.advise_item,
            parent,false)

        return ViewHolder(v, mListener)
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

    class ViewHolder(itemView : View, listener: onItemClickListener):
        RecyclerView.ViewHolder (itemView) {

        var img = itemView.findViewById<ImageView>(R.id.advise_img)!!
        var title = itemView.findViewById<TextView>(R.id.advise_title)!!
        var discription = itemView.findViewById<TextView>(R.id.advise_discription)!!

        init {

            itemView.medicine_cart_btn.setOnClickListener {

                listener.dataAction(adapterPosition)

            }
        }

    }
}