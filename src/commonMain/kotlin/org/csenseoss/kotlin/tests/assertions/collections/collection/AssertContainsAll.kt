package org.csenseoss.kotlin.tests.assertions.collections.collection


public fun <T> Collection<T>.assertContainsAll(
    vararg items: T,
    message: String = "Expected to find item, but was not found:"
): Unit {
    items.forEach { it: T ->
        assertContains(it, message + it)
    }
}


public fun <T> Collection<T>.assertContainsAll(
    items: Iterable<T>,
    message: String = "Expected to find item, but was not found:"
): Unit {
    items.forEach { it: T ->
        assertContains(it, message + it)
    }
}