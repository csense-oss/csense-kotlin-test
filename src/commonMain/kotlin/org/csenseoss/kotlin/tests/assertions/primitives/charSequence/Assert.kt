package org.csenseoss.kotlin.tests.assertions.primitives.charSequence

import org.csenseoss.kotlin.tests.assertions.*

public fun CharSequence?.assert(
    expected: CharSequence?,
    ignoreCase: Boolean = false,
    message: String = "Expected \"$expected\" but got \"$this\"",
) {
    if (this == null) {
        failTest(message)
    }
    this.length.assert(
        expected.length, message = message + "\nExpected length to be equal for both " +
                "actual \"$this\"(length = ${this.length}) and the " +
                "expected \"$expected\"(length = ${expected.length})"
    )

    forEachIndexed { index: Int, char: Char ->
        expected[index].assert(
            char,
            ignoreCase = ignoreCase,
            message = message +
                    "but char at index $index was '${expected[index]}' instead of '$char'"
        )
    }

}