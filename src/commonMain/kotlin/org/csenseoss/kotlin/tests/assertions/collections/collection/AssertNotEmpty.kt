package org.csenseoss.kotlin.tests.assertions.collections.collection

import org.csenseoss.kotlin.tests.assertions.*


/**
 * Asserts that this collection has content
 * @receiver [Collection]<T>
 * @param message [String]
 */
public fun <T> Collection<T>.assertNotEmpty(
    message: String = "should have content"
): Unit = this.size.assertLargerOrEqualTo(
    expected = 1,
    message = message
)