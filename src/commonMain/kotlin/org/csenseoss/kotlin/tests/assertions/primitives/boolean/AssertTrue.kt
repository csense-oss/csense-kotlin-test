package org.csenseoss.kotlin.tests.assertions.primitives.boolean

/**
 * Asserts this [Boolean] is true
 * @receiver [Boolean] the [Boolean] to test
 * @param message [String] the message to show if the receiver is not true
 */
public fun Boolean.assertTrue(message: String = "expected true, got false") {
    assert(true, message)
}