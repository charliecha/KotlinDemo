package todo

/*
 * Action types
 */
data class AddTodo(val text: String)
data class ToggleTodo(val index: Int)
data class SetVisibilityFilter(val filter: VisibilityFilter)

