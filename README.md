# To-Do List Android App (Jetpack Compose + MVVM)

This is a **complete, ready-to-open Android Studio project** — unlike the
first version I sent, this one includes the Gradle build files
(`build.gradle.kts`, `settings.gradle.kts`, `gradle.properties`, the
manifest, and resources), so Android Studio will recognize it as an actual
Android/Gradle project.

## How to open it (important: do NOT use "New Project")

1. Unzip `TodoAppFull.zip` somewhere permanent (e.g. `~/AndroidStudioProjects/TodoApp`)
   — not still inside `Downloads`.
2. Open Android Studio.
3. On the Welcome screen choose **Open** (not "New Project").
4. Select the unzipped `TodoAppFull` folder itself (the one containing
   `settings.gradle.kts`) and click Open.
5. Android Studio will detect it's a Gradle project and start syncing
   automatically. This first sync can take a few minutes — it needs to
   download the Gradle distribution and dependencies.
6. If you see a banner about the Gradle wrapper JAR being missing, click
   **"OK"** / **"Create Gradle wrapper"** if prompted — Android Studio will
   generate it using its bundled Gradle. This is normal and only happens once.
7. Once sync finishes (progress bar at the bottom clears, no red banner),
   press **Run ▶** with an emulator or device selected.

## Project structure

```
TodoAppFull/
├── build.gradle.kts              (root - plugin versions)
├── settings.gradle.kts           (declares the app module)
├── gradle.properties
├── gradle/wrapper/gradle-wrapper.properties
└── app/
    ├── build.gradle.kts          (app dependencies - Compose, Navigation, ViewModel)
    └── src/main/
        ├── AndroidManifest.xml
        ├── res/values/           (themes.xml, strings.xml)
        └── java/com/example/todoapp/
            ├── MainActivity.kt
            ├── model/Task.kt
            ├── viewmodel/TaskViewModel.kt
            ├── navigation/Screen.kt
            ├── navigation/NavGraph.kt
            └── ui/
                ├── TaskListScreen.kt
                └── AddTaskScreen.kt
```

## App flow

- **TaskListScreen** — shows all tasks in a scrollable list (LazyColumn), each
  with a checkbox (mark done) and delete icon. A floating action button (+)
  navigates to the Add screen.
- **AddTaskScreen** — a simple form (title + description) that calls
  `viewModel.addTask()` and navigates back on save.
- **TaskViewModel** — single source of truth. Holds tasks in a `StateFlow`,
  exposes `addTask()`, `deleteTask()`, `toggleDone()`. Both screens share the
  *same* ViewModel instance (created once in `NavGraph.kt`), so state survives
  navigation between screens.

## Natural next steps (good interview talking points)

- Persist tasks with **Room** instead of in-memory state (you've already done
  something similar in your Expense Tracker project — same idea here).
- Add **due dates** and sort/filter by completion status.
- Add **edit task** (currently only create/delete/toggle are implemented).
- Extract `AddTask` validation into the ViewModel and expose UI events instead
  of local Composable state, for testability.
