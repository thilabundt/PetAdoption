package com.example.adoptionpet

import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PetAdapter(private val pets: List<Pet>, private val onClick: (Pet) -> Unit) : RecyclerView.Adapter<PetAdapter.PetViewHolder>() {

    class PetViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.petImage)
        val nameTextView: TextView = view.findViewById(R.id.petName)
        val locationTextView: TextView = view.findViewById(R.id.petLocation)
        val originTextView: TextView = view.findViewById(R.id.petOrigin)
        val sexAgeTextView: TextView = view.findViewById(R.id.petSexAge)
        val costTextView: TextView = view.findViewById(R.id.petCost)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pet_item, parent, false)
        return PetViewHolder(view)
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        val pet = pets[position]
        with(holder) {
            imageView.setImageResource(pet.image)
            nameTextView.text = pet.name
            locationTextView.text = pet.location

            val fullText = "Origin: ${pet.origin}"

            val spannableString = SpannableString(fullText)

            val boldSpan = StyleSpan(Typeface.BOLD)
            spannableString.setSpan(boldSpan, 0, "Origin:".length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

            originTextView.text = spannableString

            sexAgeTextView.text = "${pet.sex} | ${pet.age}"
            costTextView.text = pet.cost
            itemView.setOnClickListener { onClick(pet) }
        }
    }

    override fun getItemCount() = pets.size
}
