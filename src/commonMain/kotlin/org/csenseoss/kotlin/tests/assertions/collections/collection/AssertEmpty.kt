package org.csenseoss.kotlin.tests.assertions.collections.collection


/**
 * Asserts that this collection is empty
 * @receiver [Collection]<T>
 * @param message [String]
 */
public fun <T> Collection<T>.assertEmpty(
    message: String = "should be empty"
): Unit = assertSize(
    size = 0,
    message = message
)