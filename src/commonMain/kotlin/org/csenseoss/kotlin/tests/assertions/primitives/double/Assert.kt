package org.csenseoss.kotlin.tests.assertions.primitives.double

import kotlin.math.*
import kotlin.test.*

/**
 * Asserts that this [Double] is equal to the other double (given the [delta] / margin to account for imprecision)
 * @receiver [Double] the actual value
 * @param expected [Double] the value we expect
 * @param delta [Double] the "allowed imprecision" for value to differ from the receiver
 * @param message [String] the message to show if they differ by more than [delta]
 */
public fun Double.assert(
    expected: Double,
    delta: Double = 0.1,
    message: String = ""
) {
    if (this.isNaN() && expected.isNaN()) {
        return
    }
    val errorMessage = "expected $expected within $delta margins, but got $this."
    assertEquals(
        expected = expected,
        actual = this, absoluteTolerance = delta.absoluteValue,
        message = errorMessage + message
    )
}