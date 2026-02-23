package org.example.todo

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TodoViewModel(
    private val repository: TodoRepository
) {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    val todos: StateFlow<List<Todo>> = repository.todos

    fun addTodo(title: String) {
        scope.launch {
            repository.addTodo(title)
        }
    }

    fun toggleTodo(id: Long) {
        scope.launch {
            repository.toggleTodo(id)
        }
    }

    fun deleteTodo(id: Long) {
        scope.launch {
            repository.deleteTodo(id)
        }
    }
}