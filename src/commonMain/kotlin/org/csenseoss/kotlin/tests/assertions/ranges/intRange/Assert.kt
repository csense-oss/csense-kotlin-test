package org.csenseoss.kotlin.tests.assertions.ranges.intRange

import kotlin.test.*

/**
 * Asserts this range is the same as [otherRange]
 * @receiver [IntRange] the actual range
 * @param otherRange [IntRange] the expected range
 * @param message [String] the message to show if they differ
 */
public fun IntRange.assert(
    otherRange: IntRange,
    message: String = ""
): Unit {
    val errorMessage = "Expected $otherRange but is instead $this."
    assertEquals(otherRange, this, errorMessage + message)
}