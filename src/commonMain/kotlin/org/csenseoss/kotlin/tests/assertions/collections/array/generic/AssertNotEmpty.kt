package org.csenseoss.kotlin.tests.assertions.collections.array.generic

import org.csenseoss.kotlin.tests.assertions.*
import org.csenseoss.kotlin.tests.assertions.comparable.*


/**
 * Asserts that this array has content
 * @param message String the assertion message if the array is empty
 */
public fun <T> Array<T>.assertNotEmpty(
    message: String = "should have content"
): Unit = size.assertLargerOrEqualTo(
    expected = 1,
    message = message
)