package com.example.adoptionpet

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PetDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pet_details)

        val petImage: ImageView = findViewById(R.id.petDetailImage)
        val petName: TextView = findViewById(R.id.petDetailName)
        val petOrigin: TextView = findViewById(R.id.petDetailBreed)
        val petDetails: TextView = findViewById(R.id.petDetailDetails)
        val petPrice: TextView = findViewById(R.id.petDetailPrice)

        val imageResId = intent.getIntExtra("petImage", 0)
        if (imageResId != 0) {
            petImage.setImageResource(imageResId)
        }

        val originText = intent.getStringExtra("petOrigin") ?: ""
        val fullOriginText = "Origin: $originText"

        val spannableOrigin = SpannableString(fullOriginText).apply {
            setSpan(StyleSpan(Typeface.BOLD), 0, "Origin:".length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }



        petName.text = intent.getStringExtra("petName") ?: ""
        petOrigin.text = spannableOrigin
        petDetails.text = intent.getStringExtra("petSexAge") ?: ""
        petPrice.text = intent.getStringExtra("petCost") ?: ""

        val adoptButton: Button = findViewById(R.id.adoptButton)
        adoptButton.setOnClickListener {
            val intent = Intent(this, AdoptionActivity::class.java)
            startActivity(intent)
        }
    }
}
