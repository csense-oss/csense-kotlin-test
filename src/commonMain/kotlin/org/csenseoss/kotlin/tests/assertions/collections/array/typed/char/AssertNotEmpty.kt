package org.csenseoss.kotlin.tests.assertions.collections.array.typed.char

import org.csenseoss.kotlin.tests.assertions.comparable.*


/**
 * Asserts that this CharArray has content
 * @param message String the assertion message if the array is empty
 */
public fun CharArray.assertNotEmpty(
    message: String = "should have content"
) {
    size.assertLargerOrEqualTo(expected = 1, message = message)
}