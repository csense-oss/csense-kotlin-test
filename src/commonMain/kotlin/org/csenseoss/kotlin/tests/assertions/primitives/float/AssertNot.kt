package org.csenseoss.kotlin.tests.assertions.primitives.float

import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.math.*
import kotlin.test.*


/**
 *
 * @receiver Float
 * @param value Double
 * @param delta Double
 * @param message String
 */
public fun Float.assertNot(
    value: Float,
    delta: Float = 0.1F,
    message: String = ""
) {
    if (this.isNaN() && value.isNaN()) {
        failTest("Both $this and $value are NaN's, but expected them to be different")
    }
    val errorMessage = "expected $value to be different from $this within $delta margins, but they are equal."
    val safeDelta = abs(delta)
    assertFalse(this >= value - safeDelta && this <= value + safeDelta, errorMessage + message)
}