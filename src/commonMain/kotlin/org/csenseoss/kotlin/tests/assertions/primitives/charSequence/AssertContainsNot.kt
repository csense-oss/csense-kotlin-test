package org.csenseoss.kotlin.tests.assertions.primitives.charSequence

import org.csenseoss.kotlin.tests.assertions.general.*
import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*


/**
 * Asserts that this string does not contain the given value.
 * @receiver [String] the string to assert not containing the given [value]
 * @param value [String] the value that should NOT be in this string
 * @param ignoreCase [Boolean] if true, will ignore the casing, false means case-sensitive.
 */
public fun CharSequence?.assertContainsNot(
    value: CharSequence,
    ignoreCase: Boolean = false,
    message: String = "Could find \"$value\", in \r\n\"$this\""
) {
    this.assertNotNull()
    this.contains(value, ignoreCase = ignoreCase).assertFalse(message)
}