package org.csenseoss.kotlin.tests.assertions.collections.iterable

import org.csenseoss.kotlin.tests.assertions.general.*
import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*
import kotlin.contracts.*

/**
 * Asserts that the given list does not contain the given item
 * @receiver [List]<T>
 * @param item T
 * @param message [String]
 */
public fun <T> Iterable<T>?.assertContainsNot(
    item: T,
    message: String = "Should not contain $item (by equals), but did"
) {
    contract { returns() implies (this@assertContainsNot != null) }

    this.assertNotNull()
    contains(item).assertFalse(message = message)
}

/**
 * Asserts that the given list does not contain the given item
 * @receiver [List]<T>
 * @param item T
 * @param message [String]
 */
public fun <T> Iterable<T>?.assertContainsNot(
    predicate: (item: T) -> Boolean,
    message: String = "Should not contain by predicate, but did"
) {
    this.assertNotNull()
    any(predicate).assertFalse(message = message)
}