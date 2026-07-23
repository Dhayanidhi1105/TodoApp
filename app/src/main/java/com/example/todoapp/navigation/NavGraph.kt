package com.example.todoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todoapp.ui.AddTaskScreen
import com.example.todoapp.ui.TaskListScreen
import com.example.todoapp.viewmodel.TaskViewModel

@Composable
fun TodoNavGraph(navController: NavHostController = rememberNavController()) {

    // ViewModel is created once here and shared between screens.
    // (Both screens read/write the same list of tasks.)
    val taskViewModel: TaskViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.TaskList.route) {

        composable(Screen.TaskList.route) {
            TaskListScreen(
                viewModel = taskViewModel,
                onAddTaskClick = { navController.navigate(Screen.AddTask.route) }
            )
        }

        composable(Screen.AddTask.route) {
            AddTaskScreen(
                viewModel = taskViewModel,
                onTaskAdded = { navController.popBackStack() }
            )
        }
    }
}
