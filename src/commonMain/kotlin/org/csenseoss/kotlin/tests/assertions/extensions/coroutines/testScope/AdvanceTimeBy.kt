@file:OptIn(ExperimentalCoroutinesApi::class)

package org.csenseoss.kotlin.tests.assertions.extensions.coroutines.testScope

import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import kotlin.time.*

public fun TestScope.advanceTimeBy(duration: Duration) {
    advanceTimeBy(delayTimeMillis = duration.inWholeMilliseconds)
}