package org.csenseoss.kotlin.tests.assertions.collections.iterable

import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.contracts.*


/**
 * Asserts that this Iterable's items are different from the given [items] (none are contained)
 * @receiver [Iterable]<T>
 * @param items [Array]<out T>
 */
public fun <T> Iterable<T>?.assertContainsNone(
    vararg items: T,
    message: String = "Expected item to not be found, but was:"
) {
    this.assertNotNull()
    items.forEach { it: T ->
        assertContainsNot(it, message)
    }
}

/**
 * Asserts that this collection's items are different from the given [items] (none are contained)
 * @receiver [Collection]<T>
 * @param items [Array]<out T>
 */
public fun <T> Iterable<T>?.assertContainsNone(
    items: Iterable<T>,
    message: String = "Expected item to not be found, but was:"
){
    contract { returns() implies (this@assertContainsNone != null) }

    this.assertNotNull()
    items.forEach { it: T ->
        assertContainsNot(it, message)
    }
}