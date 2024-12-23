package org.csenseoss.kotlin.tests.assertions.primitives.charSequence

import org.csenseoss.kotlin.tests.assertions.*

public fun CharSequence?.assertNot(
    expected: CharSequence?,
    ignoreCase: Boolean = false,
    message: String = "Expected \"$this\" to be different to \"$expected\" but they are the same",
): Unit = Nullabillity.assertNullabillityNotEqualsOr(
    actual = this,
    expected = expected,
    orByAssert = { actual: CharSequence, expected: CharSequence ->

        if (actual.length != expected.length) {
            return@assertNullabillityNotEqualsOr
        }

        actual.forEachIndexed { index: Int, char: Char ->
            val areCharsEqual: Boolean = expected[index].equals(other = char, ignoreCase = ignoreCase)
            if (!areCharsEqual) {
                return@assertNot
            }
        }
        failTest(message)
    }
)