package org.csenseoss.kotlin.tests.assertions.collections.array.typed.char

import org.csenseoss.kotlin.tests.assertions.*


/**
 * Asserts that this CharArray has content
 * @param message String the assertion message if the array is empty
 */
public fun CharArray.assertNotEmpty(message: String = "should have content"): Unit =
    size.assertLargerOrEqualTo(1, message = message)