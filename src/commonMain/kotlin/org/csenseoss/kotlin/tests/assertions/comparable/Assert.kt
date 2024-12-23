package org.csenseoss.kotlin.tests.assertions.comparable

import kotlin.test.*


/**
 * Assert that this is the same as the [expected]
 * @receiver T the value to test (the actual)
 * @param expected T the expected value, that the actual should be
 * @param message [String] a message if the [expected] is different from the receiver
 */
public fun <T : Comparable<T>> T?.assert(
    expected: T,
    message: String = "expected to be equal, but \"$this\" != \"$expected\""
) {
    assertEquals(expected, this, message)
}