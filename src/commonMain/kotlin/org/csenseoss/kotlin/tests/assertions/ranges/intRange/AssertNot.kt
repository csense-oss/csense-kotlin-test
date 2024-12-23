package org.csenseoss.kotlin.tests.assertions.ranges.intRange

import kotlin.test.*


public fun IntRange.assertNot(
    otherRange: IntRange,
    message: String = ""
): Unit {
    val errorMessage = "Expected $this to be different from $otherRange but they are the same."
    assertNotEquals(otherRange, this, errorMessage + message)
}