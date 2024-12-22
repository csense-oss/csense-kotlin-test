package org.csenseoss.kotlin.tests.assertions.primitives.boolean

import kotlin.test.*


/**
 * Asserts this [Boolean] is the given value
 * @receiver [Boolean] the [Boolean] to test
 * @param value [Boolean] the expected value
 * @param message [String] the message to show if the receiver is not the given [value]
 */
public fun Boolean?.assert(value: Boolean, message: String = "expected $value got $this") {
    assertEquals(value, this, message)
}