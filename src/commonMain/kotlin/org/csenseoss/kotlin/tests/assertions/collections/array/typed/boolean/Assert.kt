package org.csenseoss.kotlin.tests.assertions.collections.array.typed.boolean

import org.csenseoss.kotlin.tests.assertions.collections.array.*
import org.csenseoss.kotlin.tests.assertions.general.*


public fun BooleanArray?.assert(
    expected: BooleanArray,
    message: String = "Expected this BooleanArray to be the same as expected but was different"
) {
    this.assertNotNull()
    ArrayAssertions.assertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = BooleanArray::size,
        getElementAt = BooleanArray::get
    )
}