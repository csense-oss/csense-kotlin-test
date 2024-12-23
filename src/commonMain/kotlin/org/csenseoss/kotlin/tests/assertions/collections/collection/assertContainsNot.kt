package org.csenseoss.kotlin.tests.assertions.collections.collection

import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*

/**
 * Asserts that the given list does not contain the given item
 * @receiver [List]<T>
 * @param item T
 * @param message [String]
 */
public fun <T> Collection<T>.assertContainsNot(
    item: T,
    message: String = "Should not contain $item (by equals), but did"
) {
    contains(item).assertFalse(message = message)
}

/**
 * Asserts that the given list does not contain the given item
 * @receiver [List]<T>
 * @param item T
 * @param message [String]
 */
public fun <T> Collection<T>.assertContainsNot(
    predicate: (item: T) -> Boolean,
    message: String = "Should not contain by predicate, but did"
) {
    any(predicate).assertFalse(message = message)
}