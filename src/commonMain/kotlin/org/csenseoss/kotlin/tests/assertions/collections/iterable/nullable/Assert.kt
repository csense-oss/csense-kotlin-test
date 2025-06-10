package org.csenseoss.kotlin.tests.assertions.collections.iterable.nullable

import org.csenseoss.kotlin.tests.assertions.collections.helpers.*
import org.csenseoss.kotlin.tests.assertions.helpers.*
import org.csenseoss.kotlin.tests.assertions.helpers.Nullabillity.assertNullabillityContinueOnNotNull
import kotlin.jvm.*


public fun <T : Comparable<T>> Iterable<T?>?.assert(
    expected: Iterable<T?>,
    message: String = ""
) {
    assertNullabillityContinueOnNotNull(
        first = this,
        second = expected,
        returnFunction = { return@assert }
    )

    DualIterator.onDualNullableIterator(
        actualIterator = iterator(),
        expectedIterator = expected.iterator(),
        messageIfDifferentSizes = "",
        message = message
    )
}

@JvmName("assertVararg")
public fun <T : Comparable<T>> Iterable<T?>?.assert(
    vararg expected: T?,
    message: String = ""
) {
    assertNullabillityContinueOnNotNull(
        first = this,
        second = expected,
        returnFunction = { return@assert }
    )

    DualIterator.onDualNullableIterator(
        actualIterator = iterator(),
        expectedIterator = expected.iterator(),
        messageIfDifferentSizes = "",
        message = message
    )
}