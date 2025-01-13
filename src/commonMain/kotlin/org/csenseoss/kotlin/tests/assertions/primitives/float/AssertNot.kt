package org.csenseoss.kotlin.tests.assertions.primitives.float

import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.math.*
import kotlin.test.*


/**
 *
 * @receiver Float
 * @param expected Double
 * @param delta Double
 * @param message String
 */
public fun Float.assertNot(
    expected: Float,
    delta: Float = 0.1F,
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