@file:Suppress("unused", "NOTHING_TO_INLINE", "MissingTestFunction")

package csense.kotlin.tests.assertions

import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

/**
 * Asserts that the this string contains the given value.
 * @receiver [String] the string to assert contains the given [value]
 * @param value [String] the value that should be in this string
 * @param ignoreCase [Boolean] if true, will ignore the casing, false means case sensitive.
 * @param message [String] the error message.
 */
inline fun String.assertContains(
    value: String,
    ignoreCase: Boolean = false,
    message: String = "Could not find \"$value\", in  \r\n\"$this\""
) {
    assertTrue(this.contains(value, ignoreCase = ignoreCase), message)
}

/**
 * Asserts that the this string does not contain the given value.
 * @receiver [String] the string to assert not containing the given [value]
 * @param value [String] the value that should NOT be in this string
 * @param ignoreCase [Boolean] if true, will ignore the casing, false means case sensitive.
 */
inline fun String.assertContainsNot(
    value: String,
    ignoreCase: Boolean = false
) {
    assertFalse(
        this.contains(value, ignoreCase = ignoreCase),
        "Could find \"$value\", in \r\n\"$this\""
    )
}

/**
 * Asserts that this string is not empty (length > 0)
 * @receiver String the string to test for fullness
 */
inline fun String.assertNotEmpty() = isNotEmpty().assertTrue("Expected string to not be empty but it was")

/**
 * Asserts that this string is empty (length == 0)
 * @receiver String the string to test for emptiness
 */
inline fun String.assertEmpty() = isEmpty().assertTrue("Expected string to be empty but was instead \"$this\"")

/**
 * Asserts that the this string is the same as the given [value] (expected)
 * @receiver [String] the actual value
 * @param value [String] the expected value (to assert)
 * @param message [String] the error message if they differ
 */
inline fun String.assert(value: String, message: String = "") {
    assertEquals(value, this, message)
}

/**
 * Asserts that the this string differs from the given [value] (expected)
 * @receiver [String] the actual value
 * @param value [String] the expected value
 * @param message [String] the error message if they are the same
 */
inline fun String.assertNot(value: String, message: String = "") {
    assertNotEquals(value, this, message)
}

/**
 * Asserts that this string contains some substrings in order (increasing), such that you may say "there is some x, followed by y"
 * @receiver [String] the string to assert contains the values in order
 * @param values [List]<[String]> the list of values to be contained in order, eg "x followed by y by z", so y have to come after x. ect.
 * @param ignoreCase [Boolean] if true, will ignore casing, if false, all contains are case sensitive.
 * @param message [String] the error message
 */
inline fun String.assertContainsInOrder(
    values: List<String>,
    ignoreCase: Boolean,
    message: String = ""
) {
    var currentIndex = 0
    values.forEach {
        val next = indexOf(it, currentIndex, ignoreCase)
        if (next < 0) {
            failTest(
                "$message\n\nCould not find \n\t\"$it\" after index $currentIndex in string \n" +
                        "\"$this\"\n" +
                        "\tafter index is :\"${this.substring(currentIndex)}\""
            )
        }
        currentIndex = next + it.length
    }
}

/**
 * Asserts that this string starts with the given string.
 * @receiver [String] the string to assert starts with the given string
 * @param prefix [String] the string to be asserted to be started with
 * @param ignoreCase [Boolean] if true, will ignore casing, if false, all contains are case sensitive.
 * @param message [String] the error message if the start differs from the given prefix
 */
inline fun String.assertStartsWith(
    prefix: String,
    ignoreCase: Boolean = false,
    message: String = ""
) {
    val textOutput = "$message \n Could not find \"$prefix\", in  \n" +
            "\"$this\""
    assertTrue(this.startsWith(prefix, ignoreCase = ignoreCase), textOutput)
}

