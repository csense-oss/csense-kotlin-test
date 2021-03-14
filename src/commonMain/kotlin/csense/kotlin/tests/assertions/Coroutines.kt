@file:Suppress("unused", "NOTHING_TO_INLINE")

package csense.kotlin.tests.assertions

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext


public fun CoroutineScope.assertDispatcher(otherDispatcher: CoroutineDispatcher) {
    getCurrentDispatcher().assertAs(otherDispatcher)
}

private fun CoroutineScope.getCurrentDispatcher() = coroutineContext.getCurrentDispatcher()

private fun CoroutineContext.getCurrentDispatcher(): CoroutineDispatcher =
    this[ContinuationInterceptor] as CoroutineDispatcher