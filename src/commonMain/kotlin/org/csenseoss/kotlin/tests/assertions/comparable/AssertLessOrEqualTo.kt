package org.csenseoss.kotlin.tests.assertions.comparable

import kotlin.test.*

/**
 * Asserts the given is less than or equal to the [expected] (<=)
 * @receiver U the actual value
 * @param expected U the value the receiver should be less than or equal to
 * @param optMessage [String] if the receiver is larger than the [expected] then this will be printed
 */
public fun <U : Comparable<U>> U.assertLessOrEqualTo(expected: U, optMessage: String = "") {
    assertTrue(this <= expected, "$this should be smaller or equal to $expected, but it is not.\n$optMessage")
}