package org.csenseoss.kotlin.tests.assertions.collections.array.generic

import org.csenseoss.kotlin.annotations.numbers.limit.*
import org.csenseoss.kotlin.tests.assertions.comparable.*
import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.contracts.*

/**
 * Asserts that the size of this array is the given size.
 * @receiver [Array]<T>
 * @param size [Int] the expected size
 * @param message [String]  the message to print if the assertion fails
 */
public fun <T> Array<T>?.assertSize(
    @IntLimit(from = 0) size: Int,
    message: String = ""
) {
    contract { returns() implies (this@assertSize != null) }
    assertNotNull()
    this.size.assert(size, message)
}