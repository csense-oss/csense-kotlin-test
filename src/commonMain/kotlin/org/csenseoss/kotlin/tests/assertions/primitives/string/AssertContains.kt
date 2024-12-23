package org.csenseoss.kotlin.tests.assertions.primitives.string

import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*


/**
 * Asserts that this string contains the given value.
 * @receiver [String] the string to assert contains the given [value]
 * @param value [String] the value that should be in this string
 * @param ignoreCase [Boolean] if true, will ignore the casing, false means case-sensitive.
 * @param message [String] the error message.
 */
public fun String.assertContains(
    value: String,
    ignoreCase: Boolean = false,
    message: String = "Could not find \"$value\", in \r\n\"$this\""
) {
    this.contains(
        other = value,
        ignoreCase = ignoreCase
    ).assertTrue(message = message)
}