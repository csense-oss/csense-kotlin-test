@file:Suppress("unused", "INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package org.csenseoss.kotlin.tests.assertions.collections.collection

import org.csenseoss.kotlin.tests.assertions.comparable.*
import kotlin.contracts.*


/**
 * Asserts that there is only 1 element (the given) in this list
 * @receiver [Collection]<T>
 * @param expected T
 */
public fun <T> Collection<T>.assertSingle(
    expected: T,
    message: String = "Expected $this to be $expected (using equals) but is not"
) where T : Comparable<T> {
    assertSize(size = 1)
    first().assert(expected, message)
}

/**
 * asserts that there is a single item and if so invokes the [callback]
 * @receiver [Collection]<T>
 * @param callback (T) -> Unit
 */

public inline fun <T> Collection<T>.assertSingle(callback: (T) -> Unit) {
    contract {
        callsInPlace(callback, InvocationKind.AT_MOST_ONCE)
    }
    assertSize(size = 1)
    callback(first())
}