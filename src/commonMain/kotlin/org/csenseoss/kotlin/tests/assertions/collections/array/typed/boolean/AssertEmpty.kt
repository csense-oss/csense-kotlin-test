package org.csenseoss.kotlin.tests.assertions.collections.array.typed.boolean

/**
 * Asserts that this array is empty
 * @param message [String] the message to print if the assertion fails
 */
public fun BooleanArray.assertEmpty(
    message: String = "should be empty"
): Unit = assertSize(
    expected = 0,
    message = message
)