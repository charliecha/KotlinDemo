package todo

object logger{
    fun info(state: AppState) {
        println("${state.todos} - ${state.visibilityFilter}")
    }

    fun info(info: String) {
        println(info)
    }
}