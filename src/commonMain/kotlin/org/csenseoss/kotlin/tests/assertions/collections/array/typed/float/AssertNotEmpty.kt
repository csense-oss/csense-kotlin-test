package org.csenseoss.kotlin.tests.assertions.collections.array.typed.float

import org.csenseoss.kotlin.tests.assertions.*


/**
 * Asserts that this FloatArray has content
 * @param message String the assertion message if the array is empty
 */
public fun FloatArray.assertNotEmpty(message: String = "should have content"): Unit =
    size.assertLargerOrEqualTo(1, message = message)