@file:Suppress("unused", "INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package org.csenseoss.kotlin.tests.assertions.collections.iterable

import org.csenseoss.kotlin.tests.assertions.*


public inline fun <@kotlin.internal.OnlyInputTypes E> Iterable<E>.assertSingle(
    message: String = "",
    expected: E
) where E : Comparable<E> {
    single().assert(
        expected = expected,
        message = message
    )
}