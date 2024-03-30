package com.example.adoptionpet

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val petRecyclerView = findViewById<RecyclerView>(R.id.petRecyclerView)
        petRecyclerView.setLayoutManager(LinearLayoutManager(this))

        val density = resources.displayMetrics.density
        val padding = (12 * density).toInt() // 16dp в пиксели
        petRecyclerView.addItemDecoration(VerticalSpaceItemDecoration(padding))

        val pets = listOf(
            Pet(name = "Kitty", image = R.drawable.cat_rounded, location = "Germany", origin = "Australian", sex = "Female", age = "9 months", cost ="45$"),
            Pet(name = "Kitty", image = R.drawable.cat2_r, location = "Germany", origin = "Australian", sex = "Female", age = "9 months", cost ="45$"),
            Pet(name = "Kitty", image = R.drawable.cat3_r, location = "Germany", origin = "Australian", sex = "Female", age = "9 months", cost ="45$"),
            Pet(name = "Kitty", image = R.drawable.cat4_r, location = "Germany", origin = "Australian", sex = "Female", age = "9 months", cost ="45$")
        )

        val adapter = PetAdapter(pets) { pet ->
            val intent = Intent(this, PetDetailActivity::class.java).apply {
                putExtra("petName", pet.name)
                putExtra("petImage", pet.image)
                putExtra("petLocation", pet.location)
                putExtra("petOrigin", pet.origin)
                putExtra("petSexAge", pet.sex+ " | " + pet.age)
                putExtra("petCost", pet.cost)
            }
            startActivity(intent)
        }

        petRecyclerView.adapter = adapter
    }
}