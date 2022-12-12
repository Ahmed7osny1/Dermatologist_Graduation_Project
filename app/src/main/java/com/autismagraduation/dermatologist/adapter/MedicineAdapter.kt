package com.autismagraduation.dermatologist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.autismagraduation.dermatologist.R
import com.autismagraduation.dermatologist.data.MedicineData

class MedicineAdapter (private var MyList: ArrayList<MedicineData>) :
    RecyclerView.Adapter<MedicineAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.medicine_item,
            parent,false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return MyList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val medicine = MyList[position]

        holder.img.setImageResource(medicine.img)
        holder.title.text = medicine.medicineName
        holder.discription.text = medicine.medicineDiscription
        holder.price.text = medicine.medicinePrice.toString()

    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder (itemView) {

        var img = itemView.findViewById<ImageView>(R.id.medicine_img)!!
        var title = itemView.findViewById<TextView>(R.id.medicine_name)!!
        var discription = itemView.findViewById<TextView>(R.id.medicine_discription)!!
        var price = itemView.findViewById<TextView>(R.id.medicine_price)!!

    }
}