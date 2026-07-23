package com.example.todoapp.model

/**
 * Simple data class representing a single To-Do item.
 * In a real app you'd likely make this a Room @Entity later —
 * that's a natural "next step" upgrade to mention in an interview.
 */
data class Task(
    val id: Int,
    val title: String,
    val description: String = "",
    val isDone: Boolean = false
)
