package org.csenseoss.kotlin.tests.assertions.primitives.boolean


/**
 * Asserts this [Boolean] is false
 * @receiver [Boolean] the [Boolean] to test
 * @param message [String] the message to show if the receiver is not false
 */
public fun Boolean.assertFalse(message: String = "expected false got true") {
    assert(false, message)
}