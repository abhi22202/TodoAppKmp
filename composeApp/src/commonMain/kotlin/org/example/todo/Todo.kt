package org.example.todo

data class Todo(
    val id: Long,
    val title: String,
    val isCompleted: Boolean = false
)