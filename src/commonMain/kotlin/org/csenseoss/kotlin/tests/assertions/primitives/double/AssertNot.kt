package org.csenseoss.kotlin.tests.assertions.primitives.double

import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.math.*
import kotlin.test.*

/**
 *
 * @receiver Double
 * @param expected Double
 * @param delta Double
 * @param message String
 */
public fun Double.assertNot(
    expected: Double,
    delta: Double = 0.1,
    message: String = ""
) {
    if (this.isNaN() && expected.isNaN()) {
        failTest("Both $this and $expected are NaN's, but expected them to be different")
    }
    val errorMessage = "expected $expected to be different from $this within $delta margins, but they are equal."
    assertNotEquals(
        illegal = expected,
        actual = this,
        message = errorMessage + message,
        absoluteTolerance = delta.absoluteValue
    )
}