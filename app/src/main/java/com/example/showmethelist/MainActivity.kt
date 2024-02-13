package com.example.showmethelist

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
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
            Item("App Foreground", "To the right of the application you can see \n"+
                    "the applications foreground which is a white \n alien guy.", R.drawable.ic_launcher_foreground),
            Item("App Background", "To the right of the application you can see \n" +
                    " the applications background which is a \n" +
                    "green grid.", R.drawable.ic_launcher_background),
            Item("Personal Image", "To the right of the application you can see \n" +
                    " the a personal image which is a \n" +
                    "character called Tiny Man from a game\n" +
                    " called Tiny Man's Revenge Remastered. (in png format.)", R.drawable.tm)
            // Add more items as needed
        )

        val listView: ListView = findViewById(R.id.listView)

        // Adapter for the ListView to display item titles
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items.map { it.title })
        listView.adapter = adapter

        // Click listener for ListView items
        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectedItem = items[position]
                val intent = Intent(this, SecondActivity::class.java).apply {
                    // Pass the selected item to the SecondActivity
                    putExtra("selectedItem", selectedItem)
                }
                startActivity(intent) // Start SecondActivity
            }
    }

    override fun onResume() {
        super.onResume()
        // Display a Snackbar when returning from SecondActivity
        Snackbar.make(findViewById(android.R.id.content), "Operation successful", Snackbar.LENGTH_SHORT).show()
    }
}
