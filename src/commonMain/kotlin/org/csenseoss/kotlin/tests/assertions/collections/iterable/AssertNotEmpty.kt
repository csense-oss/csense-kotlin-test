package org.csenseoss.kotlin.tests.assertions.collections.iterable

import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.contracts.*


/**
 * Asserts that this collection has content
 * @receiver [Collection]<T>
 * @param message [String]
 */
public fun <T> Iterable<T>?.assertNotEmpty(
    message: String = "Expected $this to have content but was empty",
) {
    contract { returns() implies (this@assertNotEmpty != null) }

    this.assertNotNull()
    val isNotEmpty: Boolean = iterator().hasNext()
    if (isNotEmpty) {
        return
    }
    failTest(message)
}