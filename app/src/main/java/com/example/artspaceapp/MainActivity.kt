package com.example.artspaceapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var paintings: Array<Int>
    private lateinit var descriptions: Array<String>
    private lateinit var authors: Array<String>

    private var currentIndex = 0

    private lateinit var paintingImageView: ImageView
    private lateinit var descriptionTextView: TextView
    private lateinit var authorDateTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        paintingImageView = findViewById(R.id.paintings)
        descriptionTextView = findViewById(R.id.myImageViewText)
        authorDateTextView = findViewById(R.id.author_date)

        val previousButton: Button = findViewById(R.id.previous)
        val nextButton: Button = findViewById(R.id.next)

        paintings = arrayOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5
        )

        descriptions = arrayOf(
            "Las Meninas",
            "The Birth of Venus",
            "Water Lilies",
            "Café Terrace at Night",
            "The Starry Night"
        )

        authors = arrayOf(
            "Diego Velázquez (1656)",
            "Sandro Botticelli (1486)",
            "Claude Monet (1919)",
            "Vincent van Gogh (1888)",
            "Vincent van Gogh (1889)"
        )

        updateUI()

        previousButton.setOnClickListener {
            currentIndex = (currentIndex - 1 + paintings.size) % paintings.size
            Log.d("MainActivity", "Previous Index: $currentIndex")
            updateUI()
        }

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % paintings.size
            Log.d("MainActivity", "Next Index: $currentIndex")
            updateUI()
        }
    }

    private fun updateUI() {
        Log.d("MainActivity", "Current Index: $currentIndex")
        paintingImageView.setImageResource(paintings[currentIndex])
        descriptionTextView.text = descriptions[currentIndex]
        authorDateTextView.text = authors[currentIndex]
    }
}
