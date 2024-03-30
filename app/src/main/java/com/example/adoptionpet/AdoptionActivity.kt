package com.example.adoptionpet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AdoptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat_adopt)

        val messages = listOf(
            Message(1, "Привет! Меня заинтересовал ваш питомец.", true, R.drawable.peopl1),
            Message(2, "Здравствуйте! Расскажите, какие у вас вопросы?", false, R.drawable.peopl2),
        )

        val messageAdapter = MessageAdapter(messages)

        val recyclerView: RecyclerView = findViewById(R.id.chatRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = messageAdapter
    }
}