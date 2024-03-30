package com.example.adoptionpet

data class Message(
    val id: Int,
    val text: String,
    val isUserMessage: Boolean,
    val imageResId: Int
)
