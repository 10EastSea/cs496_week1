package com.example.cs496_week1.fragments.album_fragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.cs496_week1.R

class RecyclerAdapterImage(img: ArrayList<Int>) : RecyclerView.Adapter<RecyclerAdapterImage.ViewHolder>() {

    private val img = img

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImg: ImageView

        init {
            itemImg = itemView.findViewById(R.id.thumbImage)
            itemView.setOnClickListener {
                var position: Int = getAdapterPosition()
                val context = itemView.context
                val intent = Intent(context, FullView::class.java).apply {
                    putExtra("NUMBER", position)
                    putExtra("IMG", img[position])
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.fragment_album_thumb_view, viewGroup, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemImg.setImageResource(img[i])
    }

    override fun getItemCount(): Int {
        return img.size
    }
}