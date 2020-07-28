@file:Suppress("unused", "NOTHING_TO_INLINE", "MissingTestFunction")

package csense.kotlin.tests.assertions

import kotlin.test.assertEquals

/**
 * asserts that this enum is the same as the [expected]
 * @receiver Enum<T> the receiver / actual
 * @param expected Enum<T> the expected value
 * @param message [String]
 */
inline fun <T : Enum<T>> Enum<T>.assert(expected: Enum<T>, message: String? = "") {
    assertEquals(expected, this, message)
}

/**
 * asserts that this enum is different from [different]
 * @receiver Enum<T> the receiver / actual
 * @param different Enum<T> the value we are not expecting
 * @param message [String]
 */
inline fun <T : Enum<T>> Enum<T>.assertNotEquals(different: Enum<T>, message: String? = "") {
    assertEquals(different, this, message)
}