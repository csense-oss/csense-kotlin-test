package org.csenseoss.kotlin.tests.assertions.collections.array.typed.byte

import org.csenseoss.kotlin.tests.assertions.general.*
import org.csenseoss.kotlin.tests.assertions.primitives.byte.*


/**
 * Asserts that this array contains the only given [expected] item
 * @param expected Byte the item that this array should contain
 * @param message [String] the message to print if the equality assertion fails
 */
public fun ByteArray?.assertSingle(
    expected: Byte,
    message: String = ""
) {
    assertNotNull()
    assertSize(1, message = "Should have exactly 1 item, have: $size")
    first().assert(expected, message)
}