@file:Suppress("unused", "NOTHING_TO_INLINE", "MissingTestFunction")

package csense.kotlin.tests.assertions

import kotlin.test.assertEquals

/**
 * asserts that this enum is the same as the [expected]
 * @receiver Enum<T> the receiver / actual
 * @param expected Enum<T> the expected value
 * @param message [String]
 */
public inline fun <T : Enum<T>> Enum<T>.assert(
    expected: Enum<T>,
    message: String? = "Expected $expected but got $this"
): Unit = assertEquals(expected, this, message)

@Deprecated("naming convention", ReplaceWith("assertNot"))
public inline fun <T : Enum<T>> Enum<T>.assertNotEquals(
    different: Enum<T>,
    message: String? = "Expected $this to be different from $different but they are the same"
): Unit = assertEquals(different, this, message)

/**
 * asserts that this enum is different from [different]
 * @receiver Enum<T> the receiver / actual
 * @param different Enum<T> the value we are not expecting
 * @param message [String]
 */
public inline fun <T : Enum<T>> Enum<T>.assertNot(
    different: Enum<T>,
    message: String? = "Expected $this to be different from $different but they are the same"
): Unit = assertEquals(different, this, message)