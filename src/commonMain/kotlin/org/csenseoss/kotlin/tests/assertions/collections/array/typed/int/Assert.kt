package org.csenseoss.kotlin.tests.assertions.collections.array.typed.int

import org.csenseoss.kotlin.tests.assertions.collections.array.*
import kotlin.jvm.*


public fun IntArray.assert(
    expected: IntArray,
    message: String = "Expected this IntArray to be the same as expected but was different"
) {
    ArrayAssertions.assertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = IntArray::size,
        getElementAt = IntArray::get
    )
}

@JvmName("assertVararg")
public fun IntArray.assert(
    vararg expected: Int,
    message: String = "Expected this IntArray to be the same as expected but was different"
) {
    ArrayAssertions.assertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = IntArray::size,
        getElementAt = IntArray::get
    )
}