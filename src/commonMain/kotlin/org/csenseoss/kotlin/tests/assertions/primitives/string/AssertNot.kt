package org.csenseoss.kotlin.tests.assertions.primitives.string

import org.csenseoss.kotlin.tests.assertions.general.*


/**
 * Asserts that this string differs from the given [expected]
 * @receiver [String] the actual value
 * @param expected [String] the expected value
 * @param message [String] the error message if they are the same
 */
public fun String.assertNot(
    expected: String,
    ignoreCase: Boolean = false,
    message: String = ""
) {
    val isEqual: Boolean = this.equals(
        other = expected,
        ignoreCase = ignoreCase
    )
    if (isEqual) {
        failTest("Expected \"$this\" to be different from \"$expected\". $message")
    }
}