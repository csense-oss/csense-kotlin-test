@file:Suppress("NOTHING_TO_INLINE")

package org.csenseoss.kotlin.tests.assertions.collections.iterable

import org.csenseoss.kotlin.tests.assertions.comparable.*
import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.contracts.*

public fun <S : T?, T : Comparable<T>> Iterable<S>?.assertSingle(
    expected: S,
    message: String = "Expected $this to be $expected (using equals) but is not"
) {
    contract { returns() implies (this@assertSingle != null) }
    this.assertNotNull()
    single().assert(
        expected = expected,
        message = message
    )
}

/**
 * asserts that there is a single item and if so invokes the [callback]
 * @receiver [Collection]<T>
 * @param callback (T) -> Unit
 */

public inline fun <T> Iterable<T>?.assertSingle(callback: (T) -> Unit) {
    contract {
        callsInPlace(callback, InvocationKind.AT_MOST_ONCE)
    }
    this.assertNotNull()
    assertSize(expectedCount = 1)
    callback(first())
}