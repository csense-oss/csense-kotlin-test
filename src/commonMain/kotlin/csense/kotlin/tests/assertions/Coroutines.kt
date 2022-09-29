@file:OptIn(ExperimentalCoroutinesApi::class, ExperimentalCoroutinesApi::class)
@file:Suppress("unused")

package csense.kotlin.tests.assertions

import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import kotlin.coroutines.*
import kotlin.time.*


public fun CoroutineScope.assertDispatcher(otherDispatcher: CoroutineDispatcher) {
    getCurrentDispatcher().assertAs(otherDispatcher)
}

private fun CoroutineScope.getCurrentDispatcher() = coroutineContext.getCurrentDispatcher()

private fun CoroutineContext.getCurrentDispatcher(): CoroutineDispatcher =
    this[ContinuationInterceptor] as CoroutineDispatcher


public fun TestScope.advanceTimeBy(duration: Duration) {
    advanceTimeBy(delayTimeMillis = duration.inWholeMilliseconds)
}