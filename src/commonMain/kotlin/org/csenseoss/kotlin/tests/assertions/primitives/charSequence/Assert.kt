package org.csenseoss.kotlin.tests.assertions.primitives.charSequence

import org.csenseoss.kotlin.tests.assertions.comparable.*
import org.csenseoss.kotlin.tests.assertions.general.*
import org.csenseoss.kotlin.tests.assertions.primitives.char.*

/**
 * Asserts that this [CharSequence] is the same as the given [CharSequence] (expected)
 * @receiver [CharSequence] the actual value
 * @param expected [CharSequence] the expected value (to assert)
 * @param message [String] the error message if they differ
 */
public fun CharSequence?.assert(
    expected: CharSequence,
    ignoreCase: Boolean = false,
    message: String = "Expected \"$expected\" but got \"$this\"",
) {
    this.assertNotNull()
    this.length.assert(
        expected.length, message = message + "\nExpected length to be equal for both " +
                "actual \"$this\"(length = ${this.length}) and the " +
                "expected \"$expected\"(length = ${expected.length})"
    )

    forEachIndexed { index: Int, expectedChar: Char ->
        expected[index].assert(
            expected = expectedChar,
            ignoreCase = ignoreCase,
            message = message +
                    "but char at index $index was '${expected[index]}' instead of '$expectedChar'"
        )
    }

}