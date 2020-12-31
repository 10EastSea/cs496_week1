package com.example.cs496_week1.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.recyclerview.widget.RecyclerView
import com.example.cs496_week1.fragments.contact_fragment.ContactInfo
import com.example.cs496_week1.R

class RecyclerAdapter(cursor: ArrayList<ContactInfo>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var data = cursor

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemName: TextView
        var itemStudentId: TextView
        var itemNumber: TextView
        var itemPhoto: ImageView

        init {
            itemName = itemView.findViewById(R.id.name)
            itemStudentId = itemView.findViewById(R.id.student_id)
            itemNumber = itemView.findViewById(R.id.phone_number)
            itemPhoto = itemView.findViewById(R.id.photo)

            itemView.setOnClickListener {
                var position = adapterPosition
                val context = itemView.context
                Toast.makeText(context, "" + position + " was clicked", LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_contract_card_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text = data[position].name
        holder.itemStudentId.text = data[position].number
        holder.itemNumber.text = data[position].name
        if (data[position].image != null) {
            holder.itemPhoto.setImageBitmap(data[position].image)
        } else {
            holder.itemPhoto.setImageResource(R.drawable.ic_baseline_person_24)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}