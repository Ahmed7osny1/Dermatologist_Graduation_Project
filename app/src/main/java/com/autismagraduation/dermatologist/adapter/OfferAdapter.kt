package com.autismagraduation.dermatologist.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.data.DataX
import com.autismagraduation.dermatologist.`object`.Constants
import com.squareup.picasso.Picasso

class OfferAdapter (private var MyList: ArrayList<DataX>) :
    RecyclerView.Adapter<OfferAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {

        fun bookAction(position: Int)
    }

    fun setonItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.offer_item, parent,false)

        return ViewHolder(v, mListener)
    }

    override fun getItemCount(): Int {
        return MyList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = MyList[position]

        Picasso.get()
            .load("${Constants.BASE_IMG}${product.medicine_id.medicine_image}")
            .into(holder.img)
        holder.title.text = product.medicine_id.medicine_name
        holder.discription.text = product.medicine_id.medicine_description
        holder.oldPrice.text = "${product.medicine_id.medicine_price} EGP"

        holder.newPrice.text = "${product.medicine_id.medicine_price -
                (product.offer*product.medicine_id.medicine_price)/100.0}"

        holder.pharmacyName.text = product.pharmacy_id.name

        holder.oldPrice.paintFlags =  Paint.STRIKE_THRU_TEXT_FLAG

    }

    class ViewHolder(itemView : View,  listener: onItemClickListener)
        : RecyclerView.ViewHolder (itemView) {

        var img = itemView.findViewById<ImageView>(R.id.product_img)!!
        var title = itemView.findViewById<TextView>(R.id.product_name)!!
        var discription = itemView.findViewById<TextView>(R.id.product_discription)!!
        var newPrice = itemView.findViewById<TextView>(R.id.new_price)!!
        var oldPrice = itemView.findViewById<TextView>(R.id.prevous_price)!!
        var pharmacyName = itemView.findViewById<TextView>(R.id.pharmacyName)!!
        var btn = itemView.findViewById<Button>(R.id.product_cart_btn)
        init {

            btn.setOnClickListener {

                listener.bookAction(adapterPosition)

            }
        }

    }
}