package org.csenseoss.kotlin.tests.assertions.collections.array.typed.short

import org.csenseoss.kotlin.tests.assertions.collections.array.*
import kotlin.jvm.*

public fun ShortArray.assert(
    expected: ShortArray,
    message: String = "Expected this ShortArray to be the same as expected but was different"
) {
    ArrayAssertions.assertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = ShortArray::size,
        getElementAt = ShortArray::get
    )
}

@JvmName("assertVararg")
public fun ShortArray.assert(
    vararg expected: Short,
    message: String = ""
) {
    ArrayAssertions.assertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = ShortArray::size,
        getElementAt = ShortArray::get
    )
}