@file:Suppress("NOTHING_TO_INLINE")
package org.csenseoss.kotlin.tests.assertions.collections.iterable

import org.csenseoss.kotlin.tests.assertions.comparable.*
import org.csenseoss.kotlin.tests.assertions.general.*

public inline fun <T> Iterable<T>?.assert(
    expected: Iterable<T>,
    message: String = ""
) where T : Comparable<T> {
    this.assertNotNull()
    assertSize(expectedIterable = expected)
    val expectedCount: Int = expected.count()
    val actualCount: Int = count()
    actualCount.assert(expectedCount, "Expected to have $expectedCount items, but is $actualCount")

    val expectedIterator: Iterator<T> = expected.iterator()
    val actualIterator: Iterator<T> = iterator()
    while (actualIterator.hasNext() && expectedIterator.hasNext()) {
        val actualItem: T = actualIterator.next()
        val expectedItem: T = expectedIterator.next()
        actualItem.assert(expectedItem, message)
    }
}

public inline fun <T> Iterable<T>?.assert(
    vararg expected: T,
    message: String = ""
) where T : Comparable<T> {
    this.assertNotNull()
    assert(expected = expected.toList(), message = message)
}