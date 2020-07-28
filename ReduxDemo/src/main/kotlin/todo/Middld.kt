package todo

import org.reduxkotlin.*

/**
 * Logs all actions and states after they are dispatched.
 */
val loggerMiddleware = middleware<AppState> { store, next, action ->
    val result = next(action)
    logger.info("11 DISPATCH action: $action")
    logger.info("11 next state: ${store.state} ${result}")
    action
}

/**
 * Same functionality as above, but declared using a function
 */
fun loggerMiddleware2(store: Store<AppState>) = { next: Dispatcher ->
    { action: Any ->
        val result = next(action)
        logger.info("22 DISPATCH action:  $action ")
        logger.info("22  next state: ${store.state} ${result}")
        result
    }
}

/**
 * Sends crash reports as state is updated and listeners are notified.
 */
val crashReporter = middleware<AppState> { store, next, action ->
    try {
        return@middleware next(action)
    } catch (e: Exception) {
        // report to crashlytics, etc
        throw e
    }
}

/**
 * From redux-kotlin-thunk.  This how thunks are executed.
 */
//fun createThunkMiddleware(extraArgument: Any? = null): ThunkMiddleware =
//    { store ->
//        { next: Dispatcher ->
//            { action: Any ->
//                if (action is Function<*>) {
//                    try {
//                        (action as Thunk)(store.dispatch, store.getState, extraArgument)
//                    } catch (e: Exception) {
//                        throw IllegalArgumentException()
//                    }
//                } else {
//                    next(action)
//                }
//            }
//        }
//    }

