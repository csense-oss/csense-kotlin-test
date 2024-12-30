package org.csenseoss.kotlin.tests.assertions.primitives.charSequence

import org.csenseoss.kotlin.tests.assertions.general.*


/**
 * Asserts that this string differs from the given [expected]
 * @receiver [String] the actual value
 * @param expected [String] the expected value
 * @param message [String] the error message if they are the same
 */
public fun CharSequence?.assertNot(
    expected: CharSequence,
    ignoreCase: Boolean = false,
    message: String = ""
) {
    this.assertNotNull()
    val isEqual: Boolean = this.contentEquals(
        other = expected,
        ignoreCase
    )
    if (isEqual) {
        failTest("Expected \"$this\" to be different from \"$expected\". $message")
    }
}