package org.csenseoss.kotlin.tests.assertions.collections.array.generic

/**
 * Asserts that this array is empty
 * @receiver [Array]<T>
 * @param message [String] the message to print if the assertion fails
 */
public fun <T> Array<T>.assertEmpty(
    message: String = "should be empty"
): Unit = assertSize(0, message = message)