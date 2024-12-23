package org.csenseoss.kotlin.tests.assertions.collections.array.typed.double

import org.csenseoss.kotlin.tests.assertions.comparable.*


/**
 * Asserts that this DoubleArray has content
 * @param message String the assertion message if the array is empty
 */
public fun DoubleArray.assertNotEmpty(
    message: String = "should have content"
) {
    size.run { assertLargerOrEqualTo(expected = 1, message = message) }
}