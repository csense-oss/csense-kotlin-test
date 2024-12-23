package org.csenseoss.kotlin.tests.assertions.primitives.string

import kotlin.test.*


/**
 * Asserts that this string does not contain the given value.
 * @receiver [String] the string to assert not containing the given [value]
 * @param value [String] the value that should NOT be in this string
 * @param ignoreCase [Boolean] if true, will ignore the casing, false means case-sensitive.
 */
public fun String.assertContainsNot(
    value: String,
    ignoreCase: Boolean = false,
    message: String = "Could find \"$value\", in \r\n\"$this\""
) {
    assertFalse(
        this.contains(value, ignoreCase = ignoreCase),
        message
    )
}