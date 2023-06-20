package com.autismagraduation.dermatologist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.data.DataX
import com.autismagraduation.dermatologist.data.MedicineData
import com.autismagraduation.dermatologist.`object`.Constants
import com.squareup.picasso.Picasso

class MedicineAdapter (private var MyList: ArrayList<DataX>) :
    RecyclerView.Adapter<MedicineAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {

        fun bookAction(position: Int)
    }

    fun setonItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.medicine_item, parent,false)

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
        holder.price.text = "${product.medicine_id.medicine_price}"

        holder.pharmacyName.text = product.pharmacy_id.name

    }

    class ViewHolder(itemView : View, listener: onItemClickListener)
        : RecyclerView.ViewHolder (itemView) {

        var img = itemView.findViewById<ImageView>(R.id.medicine_img)!!
        var title = itemView.findViewById<TextView>(R.id.medicine_name)!!
        var discription = itemView.findViewById<TextView>(R.id.medicine_discription)!!
        var price = itemView.findViewById<TextView>(R.id.medicine_price)!!
        var btn = itemView.findViewById<Button>(R.id.medicine_cart_btn)
        var pharmacyName = itemView.findViewById<TextView>(R.id.pharmacyName)!!

        init {

            btn.setOnClickListener {

                listener.bookAction(adapterPosition)

            }
        }

    }
}