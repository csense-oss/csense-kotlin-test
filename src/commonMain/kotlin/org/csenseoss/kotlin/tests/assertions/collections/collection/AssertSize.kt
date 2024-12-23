package org.csenseoss.kotlin.tests.assertions.collections.collection

import org.csenseoss.kotlin.annotations.numbers.*
import org.csenseoss.kotlin.tests.assertions.*

/**
 * Asserts that the size of this collection is the given size
 * @receiver [Collection]<T>
 * @param size [Int]
 * @param message [String]
 */
public fun <T> Collection<T>.assertSize(
    @IntLimit(from = 0) size: Int,
    message: String = "Expected ${this.size} to be equal to $size"
): Unit = this.size.assert(
    expected = size,
    message = message
)


public fun <T> Collection<T>.assertSize(
    expected: Collection<T>,
    message: String = ""
) {
    this.size.assert(expected = expected.size, message = "expected size = ${expected.size},actual = $size.$message")
}