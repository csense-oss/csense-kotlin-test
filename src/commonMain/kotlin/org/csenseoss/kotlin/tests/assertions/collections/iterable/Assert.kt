@file:Suppress("NOTHING_TO_INLINE")

package org.csenseoss.kotlin.tests.assertions.collections.iterable

import org.csenseoss.kotlin.tests.assertions.collections.helpers.*
import org.csenseoss.kotlin.tests.assertions.comparable.*
import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.contracts.*

public inline fun <T> Iterable<T>?.assert(
    expected: Iterable<T>,
    message: String = ""
) where T : Comparable<T> {
    this.assertNotNull()
    DualIterator.onDualIterator(
        actualIterator = iterator(),
        expectedIterator = expected.iterator(),
        action = { actualItem: T, expectedItem: T ->
            actualItem.assert(expectedItem, message)
        },
        messageIfDifferentSizes = "Expected to have ${expected.count()} items, but is ${count()}"
    )
}

public inline fun <T> Iterable<T>?.assert(
    vararg expected: T,
    message: String = ""
) where T : Comparable<T> {
    contract { returns() implies (this@assert != null) }
    this.assertNotNull()
    assert(expected = expected.toList(), message = message)
}