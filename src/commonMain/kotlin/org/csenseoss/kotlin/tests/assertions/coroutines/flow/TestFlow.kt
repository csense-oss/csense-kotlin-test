package org.csenseoss.kotlin.tests.assertions.coroutines.flow

import kotlinx.coroutines.*


public fun CoroutineScope.testFlow(
    collectAction: suspend () -> Unit,
    sendAction: suspend () -> Unit
): Job = launch {
    launch(start = CoroutineStart.UNDISPATCHED, context = Dispatchers.Unconfined) {
        collectAction()
    }
    launch { sendAction() }.join()
}