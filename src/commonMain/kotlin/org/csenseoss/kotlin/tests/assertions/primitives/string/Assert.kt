package org.csenseoss.kotlin.tests.assertions.primitives.string

import org.csenseoss.kotlin.tests.assertions.general.*


/**
 * Asserts that this string is the same as the given [expected] (expected)
 * @receiver [String] the actual value
 * @param expected [String] the expected value (to assert)
 * @param message [String] the error message if they differ
 */
public fun String?.assert(
    expected: String,
    ignoreCase: Boolean = false,
    message: String = ""
) {
    val isEqual = this.equals(expected, ignoreCase = ignoreCase)
    if (!isEqual) {
        failTest("Expected \"$this\" to be the same as \"$expected\". $message")
    }
}