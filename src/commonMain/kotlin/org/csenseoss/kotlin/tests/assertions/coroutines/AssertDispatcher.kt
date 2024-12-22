package org.csenseoss.kotlin.tests.assertions.coroutines

import kotlinx.coroutines.*
import org.csenseoss.kotlin.tests.assertions.*
import kotlin.coroutines.*


public fun CoroutineScope.assertDispatcherDefault() {
    assertDispatcher(Dispatchers.Default)
}

public fun CoroutineScope.assertDispatcherMain() {
    assertDispatcher(Dispatchers.Main)
}

public fun CoroutineScope.assertDispatcherUnconfined() {
    assertDispatcher(Dispatchers.Unconfined)
}

public fun CoroutineScope.assertDispatcher(otherDispatcher: CoroutineDispatcher) {
    getCurrentDispatcher().assertAs(otherDispatcher)
}

private fun CoroutineScope.getCurrentDispatcher() = coroutineContext.getCurrentDispatcher()

private fun CoroutineContext.getCurrentDispatcher(): CoroutineDispatcher =
    this[ContinuationInterceptor] as CoroutineDispatcher