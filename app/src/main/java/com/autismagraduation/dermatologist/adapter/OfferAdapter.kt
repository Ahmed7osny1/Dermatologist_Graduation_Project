package com.autismagraduation.dermatologist.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.data.OfferData

class OfferAdapter (private var MyList: ArrayList<OfferData>) :
    RecyclerView.Adapter<OfferAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.offer_item, parent,false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return MyList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = MyList[position]

        holder.img.setImageResource(product.img)
        holder.title.text = product.productName
        holder.discription.text = product.productDiscription
        holder.newPrice.text = "${product.newPrice} EGP"
        holder.oldPrice.text = product.oldPrice.toString()

        holder.oldPrice.paintFlags =  Paint.STRIKE_THRU_TEXT_FLAG

    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder (itemView) {

        var img = itemView.findViewById<ImageView>(R.id.product_img)!!
        var title = itemView.findViewById<TextView>(R.id.product_name)!!
        var discription = itemView.findViewById<TextView>(R.id.product_discription)!!
        var newPrice = itemView.findViewById<TextView>(R.id.new_price)!!
        var oldPrice = itemView.findViewById<TextView>(R.id.prevous_price)!!

    }
}