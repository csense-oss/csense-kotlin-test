package org.csenseoss.kotlin.tests.assertions.collections.iterable.iterable

import org.csenseoss.kotlin.tests.assertions.collections.iterable.*
import org.csenseoss.kotlin.tests.assertions.comparable.*


public fun <T> Iterable<Iterable<T>>.assert(
    vararg expected: Iterable<T>,
    message: String = ""
) where T : Comparable<T> {
    val count: Int = count()
    count.assert(expected = expected.size, message = "expected ${expected.size} collections but $count was found")

    val expectedIterator: Iterator<Iterable<T>> = expected.iterator()
    val actualIterator: Iterator<Iterable<T>> = iterator()
    while (actualIterator.hasNext() && expectedIterator.hasNext()) {
        val actualItem: Iterable<T> = actualIterator.next()
        val expectedItem: Iterable<T> = expectedIterator.next()
        actualItem.assert(expectedItem, message)
    }
}