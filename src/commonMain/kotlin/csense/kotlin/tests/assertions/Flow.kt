package csense.kotlin.tests.assertions

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

public fun CoroutineScope.testFlow(
    collectAction: suspend () -> Unit,
    sendAction: suspend () -> Unit
): Job = launch {
    launch(start = CoroutineStart.UNDISPATCHED, context = Dispatchers.Unconfined) {
        collectAction()
    }
    launch { sendAction() }.join()
}

public suspend fun <T> Flow<T>.awaitNextItem(): T {
    return first { _: T ->
        true
    }
}