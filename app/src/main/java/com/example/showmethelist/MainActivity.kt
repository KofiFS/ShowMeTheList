package com.example.showmethelist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var items: List<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // List of items displayed in the ListView
        items = listOf(
            // Sample items with title, subtitle, and image resource ID
            Item(54321,"SWENG 888", "Advanced", "Explore advanced topics in software engineering, including software architecture, design patterns, and agile methodologies.", R.drawable.jbb),
            Item(98765, "Music Theroy 101", "Beginner", "Introduction to the fundamental principles of music theory, including notation, scales, chords, and basic harmony.",R.drawable.jbg),
            Item(24680, "AI 570", "Intermediate",  "Explore intermediate topics in artificial intelligence, covering machine learning algorithms, neural networks, and natural language processing techniques.",R.drawable.jbr),
            Item(13579, "SWENG 505", "Advanced",  "Advanced software engineering course focusing on software architecture, design patterns, and software development methodologies.",R.drawable.jby),
            Item(43215, "SWENG 581", "Advanced",  "In-depth exploration of software testing techniques, including unit testing, integration testing, and automated testing frameworks.",R.drawable.tm)
            // Add more items as needed
        )

        val listView: ListView = findViewById(R.id.listView)

        // Adapter for the ListView to display item titles
        val adapter = MyListAdapter(this, R.layout.list_item_layout, items)
        listView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        // Display a Snackbar when returning from SecondActivity
        Snackbar.make(findViewById(android.R.id.content), "Operation successful", Snackbar.LENGTH_SHORT).show()
    }

    private class MyListAdapter(context: Context, private val layout: Int, private val items: List<Item>) :
        ArrayAdapter<Item>(context, layout, items) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var convertView = convertView
            var mainViewHolder: ViewHolder? = null

            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(layout, parent, false)
                mainViewHolder = ViewHolder()
                mainViewHolder.thumbnail = convertView.findViewById(R.id.imageView)
                mainViewHolder.title = convertView.findViewById(R.id.textTitle)
                mainViewHolder.subtitle = convertView.findViewById(R.id.textSubtitle)
                mainViewHolder.button = convertView.findViewById(R.id.buttonDetails)
                convertView.tag = mainViewHolder
            } else {
                mainViewHolder = convertView.tag as ViewHolder
            }
            val currentItem = items[position]
            mainViewHolder.button?.setOnClickListener {

                val intent = Intent(context, SecondActivity::class.java).apply {
                    // Pass the selected item to the SecondActivity
                    putExtra("selectedItem", items[position])
                }
                context.startActivity(intent) // Start SecondActivity
            }

            mainViewHolder.title?.text = currentItem.title
            mainViewHolder.subtitle?.text = currentItem.subtitle
            mainViewHolder.thumbnail?.setImageResource(currentItem.imageResId)
            // Set subtitle text as needed
            // Set image resource for thumbnail image as needed

            return convertView!!
        }
    }

    class ViewHolder {
        var thumbnail: ImageView? = null
        var title: TextView? = null
        var subtitle: TextView? = null
        var button: Button? = null
    }

}
