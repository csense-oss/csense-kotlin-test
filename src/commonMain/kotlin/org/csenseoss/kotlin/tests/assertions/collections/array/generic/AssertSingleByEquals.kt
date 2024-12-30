package org.csenseoss.kotlin.tests.assertions.collections.array.generic

import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.contracts.*


/**
 * Asserts that this array contains the only given item
 * @receiver [Array]<T>
 * @param expected T the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun <T> Array<T>?.assertSingleByEquals(
    expected: T,
    message: String = ""
) {
    contract { returns() implies (this@assertSingleByEquals != null) }

    if (this == null && expected == null) {
        return
    }
    assertSingle { actual: T ->
        actual.assertByEquals(expected, message)
    }
}