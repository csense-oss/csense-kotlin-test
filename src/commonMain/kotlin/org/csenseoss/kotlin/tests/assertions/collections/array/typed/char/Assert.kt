package org.csenseoss.kotlin.tests.assertions.collections.array.typed.char

import org.csenseoss.kotlin.tests.assertions.collections.array.*


public fun CharArray.assert(
    expected: CharArray,
    message: String = "Expected this CharArray to be the same as expected but was different"
) {
    ArrayAssertions.assertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = CharArray::size,
        getElementAt = CharArray::get
    )
}