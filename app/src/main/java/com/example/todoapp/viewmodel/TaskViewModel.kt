package com.example.todoapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel holds the UI state and business logic, following the
 * Unidirectional Data Flow (UDF) pattern:
 *  - Screens READ state from `tasks` (StateFlow)
 *  - Screens SEND events by calling functions like addTask() / deleteTask()
 *  - The ViewModel is the single source of truth
 */
class TaskViewModel : ViewModel() {

    // Private mutable state - only the ViewModel can change it
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())

    // Public read-only state - exposed to the UI
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    private var nextId = 1

    fun addTask(title: String, description: String) {
        if (title.isBlank()) return
        val newTask = Task(id = nextId++, title = title, description = description)
        _tasks.update { currentList -> currentList + newTask }
    }

    fun deleteTask(taskId: Int) {
        _tasks.update { currentList -> currentList.filterNot { it.id == taskId } }
    }

    fun toggleDone(taskId: Int) {
        _tasks.update { currentList ->
            currentList.map { task ->
                if (task.id == taskId) task.copy(isDone = !task.isDone) else task
            }
        }
    }
}
