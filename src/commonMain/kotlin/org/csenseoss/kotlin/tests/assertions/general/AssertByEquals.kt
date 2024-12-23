package org.csenseoss.kotlin.tests.assertions.general


/**
 * Asserts that this is equal to expected
 */
public fun <@kotlin.internal.OnlyInputTypes T> T.assertByEquals(
    expected: T?,
    message: String? = null
) {
    val isEqual = this?.equals(expected) == true
    isEqual.assertTrue(
        message = "Expected $this to be equal (via equals) to $expected. ${message ?: ""}"
    )
}