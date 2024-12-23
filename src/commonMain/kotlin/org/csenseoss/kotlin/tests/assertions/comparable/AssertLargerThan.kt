package org.csenseoss.kotlin.tests.assertions.comparable

import kotlin.test.*


/**
 * Asserts the given is greater than the [expected] (>)
 * @receiver U the actual value
 * @param expected U the value the receiver should be greater than
 * @param optMessage [String] if the receiver is less than or equal to the [expected] then this will be printed
 */
public fun <U : Comparable<U>> U.assertLargerThan(expected: U, optMessage: String = "") {
    assertTrue(this > expected, "$this should be larger than $expected, but it is not.\n$optMessage")
}