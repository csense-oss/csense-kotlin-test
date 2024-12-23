package org.csenseoss.kotlin.tests.assertions.collections.array.generic

import org.csenseoss.kotlin.tests.assertions.*
import org.csenseoss.kotlin.tests.assertions.comparable.*
import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.contracts.*


/**
 * Asserts that this array contains the only given item
 * @receiver [Array]<T>
 * @param expected T the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun <T : Comparable<T>> Array<T>?.assertSingle(
    expected: T,
    message: String = ""
) {
    assertSingle { actual: T ->
        actual.assert(expected,message)
    }
}


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
    assertSingle { actual: T ->
        actual.assertByEquals(expected,message)
    }
}


/**
 * Asserts that this array contains the only given item and if so invokes the given [callback]
 * @receiver [Array]<T>
 * @param message [String]  the message to print if the equality assertion fails
 * @param callback Function1<T, Unit> the call to invoke if the array only have 1 element
 */
public fun <T> Array<T>?.assertSingle(
    message: String = "Should have 1 item",
    callback: (T) -> Unit
) {
    contract {
        callsInPlace(callback, InvocationKind.AT_MOST_ONCE)
    }
    assertNotNull()
    assertSize(size = 1, message = message)
    callback(first())
}