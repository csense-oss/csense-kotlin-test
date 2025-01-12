package org.csenseoss.kotlin.tests.assertions.collections.array.typed.float

import org.csenseoss.kotlin.tests.assertions.collections.array.*
import kotlin.jvm.*

public fun FloatArray.assert(
    expected: FloatArray,
    message: String = "Expected this FloatArray to be the same as expected but was different"
) {
    ArrayAssertions.assertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = FloatArray::size,
        getElementAt = FloatArray::get
    )
}

@JvmName("assertVararg")
public fun FloatArray.assert(
    vararg expected: Float,
    message: String = "Expected this FloatArray to be the same as expected but was different"
) {
    ArrayAssertions.assertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = FloatArray::size,
        getElementAt = FloatArray::get
    )
}