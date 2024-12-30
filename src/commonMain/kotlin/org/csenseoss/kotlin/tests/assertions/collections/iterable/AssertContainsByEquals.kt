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
public fun <T> Iterable<T>?.assertContainsByEquals(
    item: T,
    message: String = "Should contain $item (using equals), but did not"
) {
    this.assertNotNull()
    contains(item).assertTrue(message = message)
}