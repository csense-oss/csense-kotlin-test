package org.csenseoss.kotlin.tests.assertions.collections.collection

import org.csenseoss.kotlin.tests.assertions.general.*


/**
 * Asserts that there is only 1 element (the given) in this list
 * @receiver [Collection]<T>
 * @param expected T
 */
public fun <T> Collection<T>.assertSingleByEquals(
    expected: T,
    message: String = "Expected $this to be $expected (using equals) but is not"
) {
    assertSize(size = 1)
    first().assertByEquals(expected = expected, message = message)
}