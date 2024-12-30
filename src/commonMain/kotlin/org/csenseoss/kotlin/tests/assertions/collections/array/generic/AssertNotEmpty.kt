package org.csenseoss.kotlin.tests.assertions.collections.array.generic

import org.csenseoss.kotlin.tests.assertions.comparable.*
import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.contracts.*


/**
 * Asserts that this array has content
 * @param message String the assertion message if the array is empty
 */
public fun <T> Array<T>?.assertNotEmpty(
    message: String = "should have content"
) {
    contract { returns() implies (this@assertNotEmpty != null) }

    assertNotNull()
    size.assertLargerOrEqualTo(
        expected = 1,
        message = message
    )
}