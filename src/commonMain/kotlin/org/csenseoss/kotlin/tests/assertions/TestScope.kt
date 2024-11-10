@file:OptIn(ExperimentalCoroutinesApi::class, ExperimentalCoroutinesApi::class)
@file:Suppress("unused")

package org.csenseoss.kotlin.tests.assertions

import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import kotlin.time.*


public fun TestScope.advanceTimeBy(duration: Duration) {
    advanceTimeBy(delayTimeMillis = duration.inWholeMilliseconds)
}