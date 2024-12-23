package org.csenseoss.kotlin.tests.assertions.primitives.double

import kotlin.math.*
import kotlin.test.*

/**
 * Asserts that this [Double] is equal to the other double (given the [delta] / margin to account for imprecision)
 * @receiver [Double] the actual value
 * @param value [Double] the value we expect
 * @param delta [Double] the "allowed imprecision" for value to differ from the receiver
 * @param message [String] the message to show if they differ by more than [delta]
 */
public fun Double.assert(
    value: Double,
    delta: Double = 0.1,
    message: String = ""
) {
    if (this.isNaN() && value.isNaN()) {
        return
    }
    val errorMessage = "expected $value within $delta margins, but got $this."
    val safeDelta = abs(delta)
    assertTrue(this >= value - safeDelta && this <= value + safeDelta, errorMessage + message)
}