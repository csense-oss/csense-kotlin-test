package org.csenseoss.kotlin.tests.assertions.collections.array.typed.long


/**
 * Asserts that this array is empty
 * @param message [String] the message to print if the assertion fails
 */
public fun LongArray.assertEmpty(message: String = "should be empty"): Unit = assertSize(0, message = message)