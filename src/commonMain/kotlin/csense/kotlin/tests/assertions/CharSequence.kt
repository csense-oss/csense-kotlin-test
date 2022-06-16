package csense.kotlin.tests.assertions


public fun CharSequence?.assert(expected: CharSequence, ignoreCase: Boolean = false) {
    if (this == null) {
        failTest("Expected $expected but got $this")
    }
    this.length.assert(
        expected.length, message = "expected length to be equal for both " +
                "actual \"$this\"(length = ${this.length}) and the " +
                "expected \"$expected\"(length = ${expected.length})"
    )

    forEachIndexed { index, char ->
        expected[index].assert(
            char,
            ignoreCase = ignoreCase,
            message = "Expected \"$this\" to be equal to \"$expected\" " +
                    "but char at index $index was '${expected[index]}' instead of '$char'"
        )
    }

}

public fun CharSequence.assertNot(expected: CharSequence, ignoreCase: Boolean = false) {
    if (this.length != expected.length) {
        return
    }

    forEachIndexed { index, char ->
        val areCharsEqual = expected[index].equals(char, ignoreCase = ignoreCase)
        if (!areCharsEqual) {
            return@assertNot
        }
    }
    failTest(
        "Expected \"$this\" to be different to \"$expected\" but they are the same"
    )

}
