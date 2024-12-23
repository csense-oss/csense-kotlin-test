package org.csenseoss.kotlin.tests.assertions.collections.array.typed.boolean

import org.csenseoss.kotlin.tests.assertions.comparable.*


/**
 * Asserts that this BooleanArray has content
 * @param message String the assertion message if the array is empty
 */
public fun BooleanArray.assertNotEmpty(message: String = "should have content"): Unit =
    size.assertLargerOrEqualTo(1, message = message)