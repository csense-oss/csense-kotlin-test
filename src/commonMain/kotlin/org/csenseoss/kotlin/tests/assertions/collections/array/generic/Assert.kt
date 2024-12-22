package org.csenseoss.kotlin.tests.assertions.collections.array.generic

import org.csenseoss.kotlin.tests.assertions.collections.array.*


public fun <T : Comparable<T>> Array<out T>.assert(
    expected: Array<out T>,
    message: String = "Expected this Array to be the same as expected but was different"
) {
    ArrayAssertions.assertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = { size },
        getElementAt = { get(it) }
    )
}