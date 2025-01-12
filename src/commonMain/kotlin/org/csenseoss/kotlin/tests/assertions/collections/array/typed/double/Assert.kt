package org.csenseoss.kotlin.tests.assertions.collections.array.typed.double

import org.csenseoss.kotlin.tests.assertions.collections.array.*
import kotlin.jvm.*


public fun DoubleArray.assert(
    expected: DoubleArray,
    message: String = "Expected this DoubleArray to be the same as expected but was different"
) {
    ArrayAssertions.assertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = DoubleArray::size,
        getElementAt = DoubleArray::get
    )
}

@JvmName("assertVararg")
public fun DoubleArray.assert(
    vararg expected: Double,
    message: String = "Expected this DoubleArray to be the same as expected but was different"
) {
    ArrayAssertions.assertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = DoubleArray::size,
        getElementAt = DoubleArray::get
    )
}