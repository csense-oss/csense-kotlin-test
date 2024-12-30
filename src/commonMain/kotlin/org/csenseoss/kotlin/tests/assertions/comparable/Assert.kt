@file:Suppress("NOTHING_TO_INLINE")

package org.csenseoss.kotlin.tests.assertions.comparable

import kotlin.test.*


/**
 * Assert that this is the same as the [expected]
 * @receiver S the value to test (the actual)
 * @param expected S the expected value, that the actual should be
 * @param message [String] a message if the [expected] is different from the receiver
 */
public fun <S : T?, T : Comparable<T>> S.assert(
    expected: S,
    message: String = "expected to be equal, but \"$this\" != \"$expected\""
) {
    assertEquals(expected, this, message)
}