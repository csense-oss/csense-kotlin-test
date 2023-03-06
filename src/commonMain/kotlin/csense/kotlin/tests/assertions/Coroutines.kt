@file:Suppress("unused")

package csense.kotlin.tests.assertions

import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import kotlin.coroutines.*
import kotlin.time.*

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

