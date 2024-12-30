package org.csenseoss.kotlin.tests.assertions.primitives.char

import org.csenseoss.kotlin.tests.assertions.general.*

/**
 * Asserts this [Char] is the same as the given [expected]
 * @receiver [Char] the actual char
 * @param expected [Char] the expected char
 * @param message [String] the message to show if they differ
 */
public fun Char.assert(
    expected: Char,
    ignoreCase: Boolean = false,
    message: String = ""
) {
    val isEqual: Boolean = this.equals(expected, ignoreCase)
    if (!isEqual) {
        val errorMessage = "Expected $expected but is instead $this."
        failTest(errorMessage + message)
    }
}