package org.csenseoss.kotlin.tests.assertions.primitives.char

import org.csenseoss.kotlin.tests.assertions.general.*

/**
 * Asserts this [Char] is the same as the given [value]
 * @receiver [Char] the actual char
 * @param value [Char] the expected char
 * @param message [String] the message to show if they differ
 */
public fun Char.assert(
    value: Char,
    ignoreCase: Boolean = false,
    message: String = ""
) {
    val isEqual = this.equals(value, ignoreCase)
    if (!isEqual) {
        val errorMessage = "Expected $value but is instead $this."
        failTest(errorMessage + message)
    }
}