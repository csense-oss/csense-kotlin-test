package org.csenseoss.kotlin.tests.assertions.collections.array.generic

import org.csenseoss.kotlin.tests.assertions.collections.array.*
import org.csenseoss.kotlin.tests.assertions.collections.iterable.*
import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.contracts.*


public fun <T : Comparable<T>> Array<out T>?.assert(
    expected: Array<out T>,
    message: String = "Expected this Array to be the same as expected but was different"
) {
    contract { returns() implies (this@assert != null) }

    this.assertNotNull()
    ArrayAssertions.assertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = { size },
        getElementAt = { get(it) }
    )
}