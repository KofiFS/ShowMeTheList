package com.example.showmethelist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ItemAdapter(context: Context, private val items: List<Item>) :
    ArrayAdapter<Item>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            // Inflate the item layout if the view is null
            itemView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        }

        // Get the current item from the list
        val currentItem = getItem(position)

        // Initialize views in the item layout
        val titleTextView = itemView!!.findViewById<TextView>(R.id.titleTextView)
        val subtitleTextView = itemView.findViewById<TextView>(R.id.subtitleTextView)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)

        // Set data to views if the current item is not null
        currentItem?.let {
            titleTextView.text = it.title
            subtitleTextView.text = it.subtitle
            imageView.setImageResource(it.imageResId)
        }

        return itemView // Return the populated item view
    }
}
