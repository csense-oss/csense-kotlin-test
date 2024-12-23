package org.csenseoss.kotlin.tests.assertions.comparable

import kotlin.test.*

/**
 * Asserts the given is less than the [expected] (<)
 * @receiver U the actual value
 * @param expected U the value the receiver should be less than
 * @param optMessage [String] if the receiver is greater or equal to the [expected] then this will be printed
 */
public fun <U : Comparable<U>> U.assertLessThan(expected: U, optMessage: String = "") {
    assertTrue(this < expected, "$this should be smaller than $expected, but it is not.\n$optMessage")
}