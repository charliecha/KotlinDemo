package todo

/*
 * Other declarations
 */

enum class VisibilityFilter {
    SHOW_ALL,
    SHOW_COMPLETED,
    SHOW_ACTIVE
}

data class Todo(val text : String, val completed : Boolean) {
    fun copy(completed : Boolean) : Todo {
        return Todo(text, completed)
    }

    fun copy(text : String) : Todo {
        return Todo(text, completed)
    }
}

data class AppState(val todos : List<Todo>, val visibilityFilter : VisibilityFilter)