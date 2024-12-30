package org.csenseoss.kotlin.tests.assertions.collections.iterable

import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.contracts.*


/**
 * Asserts that there is only 1 element (the given) in this list
 * @receiver [Collection]<T>
 * @param expected T
 */
public fun <T> Iterable<T>?.assertSingleByEquals(
    expected: T,
    message: String = "Expected $this to be $expected (using equals) but is not"
) {
    contract { returns() implies (this@assertSingleByEquals != null) }
    this.assertNotNull()
    assertSize(expectedCount = 1)
    first().assertByEquals(expected = expected, message = message)
}