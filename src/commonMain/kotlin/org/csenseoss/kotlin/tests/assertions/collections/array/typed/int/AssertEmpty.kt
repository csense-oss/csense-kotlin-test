package org.csenseoss.kotlin.tests.assertions.collections.array.typed.int

/**
 * Asserts that this array is empty
 * @param message [String] the message to print if the assertion fails
 */
public fun IntArray.assertEmpty(
    message: String = "should be empty"
): Unit = assertSize(
    size = 0,
    message = message
)