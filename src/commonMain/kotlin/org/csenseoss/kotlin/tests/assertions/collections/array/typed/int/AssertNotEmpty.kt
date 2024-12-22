package org.csenseoss.kotlin.tests.assertions.collections.array.typed.int

import org.csenseoss.kotlin.tests.assertions.*


/**
 * Asserts that this IntArray has content
 * @param message String the assertion message if the array is empty
 */
public fun IntArray.assertNotEmpty(message: String = "should have content"): Unit =
    size.assertLargerOrEqualTo(1, message = message)