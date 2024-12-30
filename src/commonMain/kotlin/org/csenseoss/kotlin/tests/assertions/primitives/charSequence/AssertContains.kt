package org.csenseoss.kotlin.tests.assertions.primitives.charSequence

import org.csenseoss.kotlin.tests.assertions.general.*
import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*


/**
 * Asserts that this string contains the given value.
 * @receiver [CharSequence] the string to assert contains the given [value]
 * @param value [CharSequence] the value that should be in this string
 * @param ignoreCase [Boolean] if true, will ignore the casing, false means case-sensitive.
 * @param message [String] the error message.
 */
public fun CharSequence?.assertContains(
    value: CharSequence,
    ignoreCase: Boolean = false,
    message: String = "Could not find \"$value\", in \r\n\"$this\""
) {
    this.assertNotNull()
    this.contains(
        other = value,
        ignoreCase = ignoreCase
    ).assertTrue(message = message)
}