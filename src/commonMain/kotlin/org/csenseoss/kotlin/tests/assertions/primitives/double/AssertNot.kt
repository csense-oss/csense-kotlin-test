package org.csenseoss.kotlin.tests.assertions.primitives.double

import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.math.*
import kotlin.test.*

/**
 *
 * @receiver Double
 * @param value Double
 * @param delta Double
 * @param message String
 */
public fun Double.assertNot(
    value: Double,
    delta: Double = 0.1,
    message: String = ""
) {
    if (this.isNaN() && value.isNaN()) {
        failTest("Both $this and $value are NaN's, but expected them to be different")
    }
    val errorMessage = "expected $value to be different from $this within $delta margins, but they are equal."
    val safeDelta = abs(delta)
    assertFalse(this >= value - safeDelta && this <= value + safeDelta, errorMessage + message)
}