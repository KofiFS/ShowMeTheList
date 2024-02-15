package com.example.showmethelist

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Retrieve the selected item from the intent extras
        val selectedItem = intent.getParcelableExtra<Item>("selectedItem")

        // Initialize views to display item details
        val titleTextView: TextView = findViewById(R.id.item_title)
        val subtitleTextView: TextView = findViewById(R.id.item_subtitle)
        val descriptionTextView: TextView = findViewById(R.id.item_description)
        val imageView: ImageView = findViewById(R.id.item_thumbnail)
        val idTextView: TextView = findViewById(R.id.item_ID)

        // Set the text for title and subtitle TextViews
        titleTextView.text = "Title:\n${selectedItem?.title}"
        subtitleTextView.text = "\nSub title:\n${selectedItem?.subtitle}"
        descriptionTextView.text = "\nDescription:\n${selectedItem?.description}"

        // Set the image resource for the ImageView
        imageView.setImageResource(selectedItem?.imageResId ?: R.drawable.ic_launcher_foreground)

        // Set the id text
        idTextView.text = "ID: ${selectedItem?.id}"

        // Initialize and set click listener for the back button
        button = findViewById(R.id.backbutton)
        button.setOnClickListener(View.OnClickListener {
            // Create an intent to switch back to MainActivity upon clicking
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) // Start MainActivity
        })
    }
}
