package org.csenseoss.kotlin.tests.assertions.primitives.byte

import kotlin.test.*

/**
 * Asserts this byte is the same as the given [expected]
 * @receiver [Byte] the actual value
 * @param expected [Byte] the expected value
 * @param message [String] the message to show if they differ
 */
public fun Byte.assert(expected: Byte, message: String = ""): Unit {
    val errorMessage = "Expected $expected but is instead $this."
    assertEquals(expected, this, errorMessage + message)
}