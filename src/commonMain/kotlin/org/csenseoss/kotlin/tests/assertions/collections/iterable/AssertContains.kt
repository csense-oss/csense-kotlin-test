@file:Suppress("unused")

package org.csenseoss.kotlin.tests.assertions.collections.iterable

import org.csenseoss.kotlin.tests.assertions.general.*
import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*
import kotlin.contracts.*


/**
 * Asserts that the given [Iterable] contains the given [item]
 * @receiver [Iterable]<T>
 * @param item T
 * @param message [String]
 */
public fun <T : Comparable<T>> Iterable<T>?.assertContains(
    item: T,
    message: String = "Should contain $item (using equals), but did not"
) {
    this.assertNotNull()
    contains(item).assertTrue(message = message)
}

/**
 * Asserts that the given [Iterable] contains the given [predicate]
 * @receiver [Iterable]<E>
 * @param predicate (item: E) -> Boolean
 * @param message [String]
 */
public inline fun <E> Iterable<E>?.assertContains(
    predicate: (item: E) -> Boolean,
    message: String = ""
) {
    contract { returns() implies (this@assertContains != null) }

    this.assertNotNull()
    val foundAny: Boolean = any { it: E ->
        predicate(it)
    }
    foundAny.assertTrue("Wanted to find a item matching the given predicate, but found none.$message")
}