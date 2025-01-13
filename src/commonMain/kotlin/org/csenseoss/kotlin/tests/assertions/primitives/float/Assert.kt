package org.csenseoss.kotlin.tests.assertions.primitives.float

import kotlin.math.*
import kotlin.test.*

/**
 * Asserts that this [Float] is equal to the other float (given the [delta] / margin to account for imprecision)
 * @receiver [Float] the actual value
 * @param expected [Float] the value we expect
 * @param delta [Float] the "allowed imprecision" for value to differ from the receiver
 * @param message [String] the message to show if they differ by more than [delta]
 */
public fun Float.assert(
    expected: Float,
    delta: Float = 0.1f,
    message: String = ""
) {
    if (this.isNaN() && expected.isNaN()) {
        return
    }
    val errorMessage = "expected $expected within $delta margins, but got $this."
    assertEquals(
        expected = expected,
        actual = this,
        absoluteTolerance = delta.absoluteValue,
        message = errorMessage + message
    )
}