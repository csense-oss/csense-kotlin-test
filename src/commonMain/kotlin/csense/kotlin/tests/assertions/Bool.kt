@file:Suppress("NOTHING_TO_INLINE")

package csense.kotlin.tests.assertions

import kotlin.test.assertEquals

/**
 * Asserts this [Boolean] is the given value
 * @receiver [Boolean] the [Boolean] to test
 * @param value [Boolean] the expected value
 * @param message [String] the message to show if the receiver is not the given [value]
 */
public inline fun Boolean.assert(value: Boolean, message: String = "expected $value got $this") {
    assertEquals(value, this, message)
}

/**
 * Asserts this [Boolean] is false
 * @receiver [Boolean] the [Boolean] to test
 * @param message [String] the message to show if the receiver is not false
 */
public inline fun Boolean.assertFalse(message: String = "expected false got true") {
    assert(false, message)
}

/**
 * Asserts this [Boolean] is true
 * @receiver [Boolean] the [Boolean] to test
 * @param message [String] the message to show if the receiver is not true
 */
public inline fun Boolean.assertTrue(message: String = "expected true, got false") {
    assert(true, message)
}