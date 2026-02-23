package org.example.todo

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlin.time.Clock



class TodoRepository {

    private val _todos = MutableStateFlow<List<Todo>>(emptyList())
    val todos: StateFlow<List<Todo>> = _todos


    fun addTodo(title: String) {
        val newTodo = Todo(
            id = Clock.System.now().toEpochMilliseconds(),
            title = title
        )
        _todos.update { it + newTodo }
    }

    fun toggleTodo(id: Long) {
        _todos.update { list ->
            list.map {
                if (it.id == id) it.copy(isCompleted = !it.isCompleted)
                else it
            }
        }
    }

    fun deleteTodo(id: Long) {
        _todos.update { list ->
            list.filterNot { it.id == id }
        }
    }
}