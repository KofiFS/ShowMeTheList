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
        val titleTextView: TextView = findViewById(R.id.titleTextView)
        val subtitleTextView: TextView = findViewById(R.id.subtitleTextView)
        val imageView: ImageView = findViewById(R.id.imageView)

        // Set the text for title and subtitle TextViews
        titleTextView.text = selectedItem?.title
        subtitleTextView.text = selectedItem?.subtitle

        // Set the image resource for the ImageView
        imageView.setImageResource(selectedItem?.imageResId ?: R.drawable.ic_launcher_foreground)

        // Initialize and set click listener for the back button
        button = findViewById(R.id.backbutton)
        button.setOnClickListener(View.OnClickListener {
            // Create an intent to switch back to MainActivity upon clicking
            val intent = Intent(this,  MainActivity::class.java)
            startActivity(intent) // Start MainActivity
        })
    }
}
