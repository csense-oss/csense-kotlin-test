package org.csenseoss.kotlin.tests.assertions.collections.array.typed.byte

import org.csenseoss.kotlin.annotations.numbers.*
import org.csenseoss.kotlin.tests.assertions.*

/**
 * Asserts the size of the given [ByteArray]
 * @receiver [ByteArray] the array to assert the size (length) of
 * @param size [Int] the size it should be, if not this will stop the test.
 * @param message [String] the message to print if the assertion fails
 */
public fun ByteArray.assertSize(
    @IntLimit(from = 0) size: Int,
    message: String = ""
): Unit = this.size.assert(
    expected = size,
    message = message
)