@file:Suppress("unused", "INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package org.csenseoss.kotlin.tests.assertions.collections.iterable

import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*


public inline fun <@kotlin.internal.OnlyInputTypes E> Iterable<E>.assertContains(
    message: String = "",
    predicate: (item: E) -> Boolean
) {
    val foundAny: Boolean = any { it: E ->
        predicate(it)
    }
    foundAny.assertTrue("Wanted to find a item matching the given predicate, but found none.$message")
}