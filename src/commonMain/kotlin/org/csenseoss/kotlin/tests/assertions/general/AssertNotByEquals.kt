package org.csenseoss.kotlin.tests.assertions.general


public fun <@kotlin.internal.OnlyInputTypes T> T.assertNotByEquals(
    unexpected: T?,
    message: String? = null
) {
    val isNotEqual = this?.equals(unexpected) != true
    isNotEqual.assertTrue(
        message = "Expected $this to be different (via equals) to $unexpected. ${message ?: ""}"
    )
}