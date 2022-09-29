@file:Suppress("unused")

package csense.kotlin.tests.assertions

import kotlinx.coroutines.*
import kotlin.coroutines.*


public fun CoroutineScope.assertDispatcher(otherDispatcher: CoroutineDispatcher) {
    getCurrentDispatcher().assertAs(otherDispatcher)
}

private fun CoroutineScope.getCurrentDispatcher() = coroutineContext.getCurrentDispatcher()

private fun CoroutineContext.getCurrentDispatcher(): CoroutineDispatcher =
    this[ContinuationInterceptor] as CoroutineDispatcher