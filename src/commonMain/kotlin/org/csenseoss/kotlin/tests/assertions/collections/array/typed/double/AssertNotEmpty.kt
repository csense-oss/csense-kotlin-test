package org.csenseoss.kotlin.tests.assertions.collections.array.typed.double

import org.csenseoss.kotlin.tests.assertions.*


/**
 * Asserts that this DoubleArray has content
 * @param message String the assertion message if the array is empty
 */
public fun DoubleArray.assertNotEmpty(message: String = "should have content"): Unit =
    size.assertLargerOrEqualTo(1, message = message)