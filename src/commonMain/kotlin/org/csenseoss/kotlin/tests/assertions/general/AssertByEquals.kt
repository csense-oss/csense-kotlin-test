@file:Suppress("unused", "INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package org.csenseoss.kotlin.tests.assertions.general

import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*


/**
 * Asserts that this is equal to expected
 */
public fun <@kotlin.internal.OnlyInputTypes T> T.assertByEquals(
    expected: T?,
    message: String? = null
) {
    val isEqual: Boolean = this?.equals(expected) == true
    isEqual.assertTrue(
        message = "Expected $this to be equal (via equals) to $expected. ${message ?: ""}"
    )
}