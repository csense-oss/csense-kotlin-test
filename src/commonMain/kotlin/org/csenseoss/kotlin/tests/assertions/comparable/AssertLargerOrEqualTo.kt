package org.csenseoss.kotlin.tests.assertions.comparable

import kotlin.test.*


/**
 * Asserts the given value is larger or equal to (>=) the asserted value
 * @receiver U the actual value
 * @param expected U the value that the receiver should be larger than or equal to
 * @param message [String] if the receiver is less than [expected] then this gets printed
 */
public fun <U : Comparable<U>> U.assertLargerOrEqualTo(expected: U, message: String = "") {
    assertTrue(this >= expected, "$this should be larger or equal to $expected, but it is not.\n$message")
}