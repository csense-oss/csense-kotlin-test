package org.csenseoss.kotlin.tests.assertions.collections.array.typed.char

import org.csenseoss.kotlin.tests.assertions.collections.array.*
import kotlin.jvm.*


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

@JvmName("assertVararg")
public fun CharArray.assert(
    vararg expected: Char,
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