package org.csenseoss.kotlin.tests.assertions.ranges.intRange

import kotlin.test.*

/**
 * Asserts this range is the same as [expected]
 * @receiver [IntRange] the actual range
 * @param expected [IntRange] the expected range
 * @param message [String] the message to show if they differ
 */
public fun IntRange.assert(
    expected: IntRange,
    message: String = ""
): Unit {
    val errorMessage = "Expected $expected but is instead $this."
    assertEquals(expected, this, errorMessage + message)
}