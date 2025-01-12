package org.csenseoss.kotlin.tests.assertions.collections.array.typed.byte

import org.csenseoss.kotlin.tests.assertions.collections.array.*
import kotlin.jvm.*


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

@JvmName("assertVararg")
public fun ByteArray.assert(
    vararg expected: Byte,
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