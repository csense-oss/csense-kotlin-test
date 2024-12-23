package org.csenseoss.kotlin.tests.assertions.collections.array.typed.boolean

import org.csenseoss.kotlin.annotations.numbers.*
import org.csenseoss.kotlin.tests.assertions.comparable.*

/**
 * Asserts the size of the given [BooleanArray]
 * @receiver [BooleanArray] the array to assert the size (length) of
 * @param expected [Int] the size it should be, if not this will stop the test.
 * @param message [String] the message to print if the assertion fails
 */
public fun BooleanArray.assertSize(
    @IntLimit(from = 0) expected: Int,
    message: String = ""
): Unit = this.size.assert(expected = expected, message = message)