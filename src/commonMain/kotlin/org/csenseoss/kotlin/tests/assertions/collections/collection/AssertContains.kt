package org.csenseoss.kotlin.tests.assertions.collections.collection

import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*


/**
 * Asserts that the given [Collection] contains the given [item]
 * @receiver [Collection]<T>
 * @param item T
 * @param message [String]
 */
public fun <T> Collection<T>.assertContains(
    item: T,
    message: String = "Should contain $item (using equals), but did not"
) {
    contains(item).assertTrue(message = message)
}

/**
 * Asserts that the given [Collection] contains the given [predicate]
 * @receiver [Collection]<T>
 * @param predicate (item: T) -> Boolean
 * @param message [String]
 */
public fun <T> Collection<T>.assertContains(
    predicate: (item: T) -> Boolean,
    message: String = "Should contain based on predicate, but did not"
) {
    any(predicate).assertTrue(message = message)
}