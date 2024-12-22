package org.csenseoss.kotlin.tests.assertions.primitives.charSequence

import org.csenseoss.kotlin.tests.assertions.*

public fun CharSequence?.assertNot(
    expected: CharSequence?,
    ignoreCase: Boolean = false,
    message: String = "Expected \"$this\" to be different to \"$expected\" but they are the same",
) {
    if (this == null && expected == null) {
        failTest("Both actual and expected was null. Was expected to be different")
    }
    if (this == null && expected != null || this != null && expected == null) {
        return
    }
    if (this.length != expected.length) {
        return
    }

    forEachIndexed { index: Int, char: Char ->
        val areCharsEqual: Boolean = expected[index].equals(other = char, ignoreCase = ignoreCase)
        if (!areCharsEqual) {
            return@assertNot
        }
    }
    failTest(message)

}