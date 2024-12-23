package org.csenseoss.kotlin.tests.assertions.collections.iterable


public inline fun Iterable<*>.assertEmpty(
    message: String = "expected this to be empty but was not"
): Unit = assertSize(
    expectedCount = 0,
    message = message
)