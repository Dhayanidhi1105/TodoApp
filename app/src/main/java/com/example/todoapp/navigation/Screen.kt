package com.example.todoapp.navigation

/**
 * Sealed class defining the navigation routes in the app.
 * Using a sealed class instead of raw strings avoids typos when navigating.
 */
sealed class Screen(val route: String) {
    object TaskList : Screen("task_list")
    object AddTask : Screen("add_task")
}
