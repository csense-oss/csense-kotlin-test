package org.csenseoss.kotlin.tests.assertions.collections.array.typed.long

import org.csenseoss.kotlin.tests.assertions.collections.array.*
import kotlin.jvm.*

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

@JvmName("assertVararg")
public fun LongArray.assert(
    vararg expected: Long,
    message: String = ""
) {
    ArrayAssertions.assertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = LongArray::size,
        getElementAt = LongArray::get
    )
}