package org.csenseoss.kotlin.tests.assertions.collections.map

import org.csenseoss.kotlin.annotations.numbers.limit.*
import org.csenseoss.kotlin.tests.assertions.comparable.*


/**
 * Assert that this map have the given size.
 * @receiver [Map]<*, *>
 * @param expected [Int] the expected size of this map
 * @param message [String] the message if this map's size differs from the [expected]
 */
public fun Map<*, *>.assertSize(
    @IntLimit(from = 0) expected: Int,
    message: String = "Expected the map to have a size of $expected, but it is instead ${this.size}"
): Unit = this.size.assert(
    expected = expected,
    message = message
)