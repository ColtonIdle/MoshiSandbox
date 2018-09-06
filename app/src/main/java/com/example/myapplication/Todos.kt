package com.example.myapplication

data class Todos(
        val userId: Int = 0,
        val id: Int = 0,
        val title: String = "",
        val completed: Boolean = false
)