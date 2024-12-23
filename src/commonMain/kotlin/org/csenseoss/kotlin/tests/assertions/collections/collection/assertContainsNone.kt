package org.csenseoss.kotlin.tests.assertions.collections.collection


/**
 * Asserts that this collection's items are different from the given [items] (none are contained)
 * @receiver [Collection]<T>
 * @param items [Array]<out T>
 */
public fun <T> Collection<T>.assertContainsNone(
    vararg items: T,
    message: String = "Expected item to not be found, but was:"
): Unit {
    items.forEach { it: T ->
        assertContainsNot(it, message)
    }
}

/**
 * Asserts that this collection's items are different from the given [items] (none are contained)
 * @receiver [Collection]<T>
 * @param items [Array]<out T>
 */
public fun <T> Collection<T>.assertContainsNone(
    items: Iterable<T>,
    message: String = "Expected item to not be found, but was:"
): Unit {
    items.forEach { it: T ->
        assertContainsNot(it, message)
    }
}