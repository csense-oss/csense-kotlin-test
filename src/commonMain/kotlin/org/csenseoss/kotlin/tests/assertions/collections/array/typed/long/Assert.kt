package org.csenseoss.kotlin.tests.assertions.collections.array.typed.long

import org.csenseoss.kotlin.tests.assertions.collections.array.*

public fun LongArray.assert(
    expected: LongArray,
    message: String = "Expected this LongArray to be the same as expected but was different"
) {
    ArrayAssertions.assertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = LongArray::size,
        getElementAt = LongArray::get
    )
}