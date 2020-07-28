import org.reduxkotlin.Reducer
import org.reduxkotlin.createThreadSafeStore
import javax.swing.Action

/**
 * This is a reducer, a pure function with (state, action) -> state signature.
 * It describes how an action transforms the state into the next state.
 *
 * The shape of the state is up to you: it can be a primitive, an array, an object, etc.
 * Usually this will be a data class, because the copy method is useful for creating the new state.
 * In this contrived example, we are just using an Int for the state.
 *
 * In this example, we use a `when` statement and type checking, but other methods are possible,
 * such as a 'type' string field, or delegating the reduction to a method on the action objects.
 */
fun reducer(state: Int, action: Any): Int =
    when (action) {
        is Increment -> state + 1
        is Decrement -> state - 1
        else -> state
    }

/**
 * Actions are plain objects that represent an action in the app. These can be
 * plain objects or data classes and have fields that hold data necessary for
 * the reducer to update the state.
 */

class Increment

class Decrement

fun main() {
    reduxTest()
}

private fun reduxTest() {
    // Create a Redux store holding the state of your app.
// 0 is the initial state

    val store = createThreadSafeStore(::reducer, 0)

// You can use subscribe() to update the UI in response to state changes.
// Normally you'd use an additional layer or view binding library rather than subscribe() directly.

    val unsubscribe = store.subscribe {
        //        logger.debug(store.state)
        println(store.state)
    }

// The only way to mutate the internal state is to dispatch an action.
// The actions can be serialized, logged or stored.
    store.dispatch(Increment())
// Current State: 1
    store.dispatch(Increment())
// Current State: 2
    store.dispatch(Decrement())
// Current State: 1

//Removes the reference to the subscription functions.
//Must be called when subscription is no longer needed to avoid a
//memory leak.
    unsubscribe()
}