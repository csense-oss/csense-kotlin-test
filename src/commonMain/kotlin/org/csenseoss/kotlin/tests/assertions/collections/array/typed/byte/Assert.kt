package org.csenseoss.kotlin.tests.assertions.collections.array.typed.byte

import org.csenseoss.kotlin.tests.assertions.collections.array.*


public fun ByteArray.assert(
    expected: ByteArray,
    message: String = "Expected this ByteArray to be the same as expected but was different"
) {
    ArrayAssertions.assertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = ByteArray::size,
        getElementAt = ByteArray::get
    )
}