package todo

import org.reduxkotlin.applyMiddleware
import org.reduxkotlin.createThreadSafeStore

fun main() {
    val INITIAL_STATE = AppState(listOf(), VisibilityFilter.SHOW_ACTIVE)
//    val store = createThreadSafeStore(::rootReducer, INITIAL_STATE)

    val store = createThreadSafeStore(
        ::rootReducer,
        INITIAL_STATE,
        applyMiddleware(
            loggerMiddleware,
            ::loggerMiddleware2,
            crashReporter
        )
    )

    //log the initial state
    logger.info(store.state)

    // Every time the state changes, log it
    // Not that subscribe() returns a function for unregistering the listener
    val unsubscribe = store.subscribe {
//        logger.info(store.state)
    }

    // Dispatch some actions
    store.dispatch(AddTodo("Learn about actions"))
    store.dispatch(AddTodo("Learn about reducers"))
    store.dispatch(AddTodo("Learn about store"))
    store.dispatch(ToggleTodo(0))
    store.dispatch(ToggleTodo(1))
    store.dispatch(SetVisibilityFilter(VisibilityFilter.SHOW_COMPLETED))

    // Stop listening to state updates
    unsubscribe()
}