package org.csenseoss.kotlin.tests.assertions.collections.iterable

import org.csenseoss.kotlin.tests.assertions.*


public inline fun Iterable<*>.assertSize(
    expectedCount: Int,
    message: String = "Expected $expectedCount size but was ${count()}"
): Unit = count().assert(
    expected = expectedCount,
    message = message
)