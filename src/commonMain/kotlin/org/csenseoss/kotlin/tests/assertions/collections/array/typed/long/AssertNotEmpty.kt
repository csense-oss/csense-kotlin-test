package org.csenseoss.kotlin.tests.assertions.collections.array.typed.long

import org.csenseoss.kotlin.tests.assertions.*


/**
 * Asserts that this LongArray has content
 * @param message String the assertion message if the array is empty
 */
public fun LongArray.assertNotEmpty(message: String = "should have content"): Unit =
    size.assertLargerOrEqualTo(1, message = message)