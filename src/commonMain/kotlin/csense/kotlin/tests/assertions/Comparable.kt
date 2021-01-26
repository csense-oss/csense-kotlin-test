@file:Suppress("unused", "NOTHING_TO_INLINE", "MissingTestFunction")

package csense.kotlin.tests.assertions

import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

/**
 * Asserts the given value is larger or equal to (>=) the asserted value
 * @receiver U the actual value
 * @param expected U the value that the receiver should be larger than or equal to
 * @param optMessage [String] if the receiver is less than [expected] then this gets printed
 */
public inline fun <U : Comparable<U>> U.assertLargerOrEqualTo(expected: U, optMessage: String = "") {
    assertTrue(this >= expected, "$this should be larger or equal to $expected, but it is not.\n$optMessage")
}

/**
 * Asserts the given is less than or equal to the [expected] (<=)
 * @receiver U the actual value
 * @param expected U the value the receiver should be less than or equal to
 * @param optMessage [String] if the receiver is larger than the [expected] then this will be printed
 */
public inline fun <U : Comparable<U>> U.assertLessOrEqualTo(expected: U, optMessage: String = "") {
    assertTrue(this <= expected, "$this should be smaller or equal to $expected, but it is not.\n$optMessage")
}

/**
 * Asserts the given is less than the [expected] (<)
 * @receiver U the actual value
 * @param expected U the value the receiver should be less than
 * @param optMessage [String] if the receiver is greater or equal to the [expected] then this will be printed
 */
public inline fun <U : Comparable<U>> U.assertLessThan(expected: U, optMessage: String = "") {
    assertTrue(this < expected, "$this should be smaller than $expected, but it is not.\n$optMessage")
}

/**
 * Asserts the given is greater than the [expected] (>)
 * @receiver U the actual value
 * @param expected U the value the receiver should be greater than
 * @param optMessage [String] if the receiver is less than or equal to the [expected] then this will be printed
 */
public inline fun <U : Comparable<U>> U.assertLargerThan(expected: U, optMessage: String = "") {
    assertTrue(this > expected, "$this should be larger than $expected, but it is not.\n$optMessage")
}


/**
 * Assert that this is different from the [other]
 * @receiver T the value to test (the actual)
 * @param other T the different value, that the actual should not be like
 * @param message [String] a message if the [other] is the same as the receiver
 */
@Deprecated("naming convention violation", replaceWith = ReplaceWith("assertNot(other, message)"))
public inline fun <T : Comparable<T>> T.assertNotEquals(
    other: T,
    message: String = "expected not to be equal, but $this == $other"
) {
    assertNotEquals(other, this, message)
}

/**
 * Assert that this is the same as the [expected]
 * @receiver T the value to test (the actual)
 * @param expected T the expected value, that the actual should be
 * @param message [String] a message if the [expected] is different from the receiver
 */
@Deprecated("naming convention violation", replaceWith = ReplaceWith("assert(expected, message)"), level = DeprecationLevel.WARNING)
public inline fun <T : Comparable<T>> T.assertEquals(
    expected: T,
    message: String = "expected to be equal, but $this !== $expected"
) {
    assertEquals(expected, this, message)
}

/**
 * Assert that this is the same as the [expected]
 * @receiver T the value to test (the actual)
 * @param expected T the expected value, that the actual should be
 * @param message [String] a message if the [expected] is different from the receiver
 */
public inline fun <T : Comparable<T>> T.assert(
    expected: T,
    message: String = "expected to be equal, but $this !== $expected"
) {
    assertEquals(expected, this, message)
}


/**
 * Asserts that this comparable is different from [different]
 * @receiver [Comparable]<T> the receiver / actual
 * @param different Enum<T> the value we are expecting this to be different from
 * @param message [String] a message if they are the same
 */
public inline fun <T : Comparable<T>> T.assertNot(
    different: T,
    message: String? = "Expected $this to be different from $different but they are the same"
): Unit = assertNotEquals(different, this, message)