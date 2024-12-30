package org.csenseoss.kotlin.tests.assertions.collections.array.generic

import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.contracts.*

/**
 * Asserts that this array is empty
 * @receiver [Array]<T>
 * @param message [String] the message to print if the assertion fails
 */
public fun <T> Array<T>?.assertEmpty(
    message: String = "should be empty"
) {
    contract { returns() implies (this@assertEmpty != null) }

    assertNotNull()
    assertSize(0, message = message)
}