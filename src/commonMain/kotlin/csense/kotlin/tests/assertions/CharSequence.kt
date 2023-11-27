package csense.kotlin.tests.assertions


public fun CharSequence?.assert(
    expected: CharSequence,
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

public fun CharSequence.assertNot(
    expected: CharSequence,
    ignoreCase: Boolean = false,
    message: String = "Expected \"$this\" to be different to \"$expected\" but they are the same",
) {
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
