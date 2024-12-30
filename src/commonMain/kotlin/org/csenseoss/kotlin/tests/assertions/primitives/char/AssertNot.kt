package org.csenseoss.kotlin.tests.assertions.primitives.char

import org.csenseoss.kotlin.tests.assertions.general.*

/**
 *
 * @receiver Char
 * @param value Char
 * @param message String
 */
public fun Char.assertNot(
    value: Char,
    ignoreCase: Boolean = false,
    message: String = ""
) {
    val isEqual = this.equals(value, ignoreCase)
    if (isEqual) {
        val errorMessage = "Expected '$this' to be different from '$value', but they are the same."
        failTest(errorMessage + message)
    }

}