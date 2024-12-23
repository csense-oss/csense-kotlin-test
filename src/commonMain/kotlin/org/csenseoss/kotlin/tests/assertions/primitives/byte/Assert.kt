package org.csenseoss.kotlin.tests.assertions.primitives.byte

import kotlin.test.*

/**
 * Asserts this byte is the same as the given [value]
 * @receiver [Byte] the actual value
 * @param value [Byte] the expected value
 * @param message [String] the message to show if they differ
 */
public fun Byte.assert(value: Byte, message: String = ""): Unit {
    val errorMessage = "Expected $value but is instead $this."
    assertEquals(value, this, errorMessage + message)
}