@file:Suppress("NOTHING_TO_INLINE")

package csense.kotlin.tests.assertions


public inline fun CharSequence.assert(other: CharSequence, ignoreCase: Boolean = false) {
    this.length.assert(
        other.length, message = "expected length to be equal for both " +
                "actual \"$this\"(length = ${this.length}) and the " +
                "expected \"$other\"(length = ${other.length})"
    )

    forEachIndexed { index, char ->
        other[index].assert(
            char,
            ignoreCase = ignoreCase,
            message = "Expected \"$this\" to be equal to \"$other\" " +
                    "but char at index $index was '${other[index]}' instead of '$char'"
        )
    }

}

public inline fun CharSequence.assertNot(other: CharSequence, ignoreCase: Boolean = false) {
    if (this.length != other.length) {
        return
    }

    forEachIndexed { index, char ->
        val areCharsEqual = other[index].equals(char, ignoreCase = ignoreCase)
        if (!areCharsEqual) {
            return@assertNot
        }
    }
    failTest(
        "Expected \"$this\" to be different to \"$other\" but they are the same"
    )

}
