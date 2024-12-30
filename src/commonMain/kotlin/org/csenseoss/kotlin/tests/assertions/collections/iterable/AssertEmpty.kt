@file:Suppress("NOTHING_TO_INLINE")
package org.csenseoss.kotlin.tests.assertions.collections.iterable

import org.csenseoss.kotlin.tests.assertions.general.*


public inline fun Iterable<*>?.assertEmpty(
    message: String = "expected this to be empty but was not"
) {
    this.assertNotNull()
    assertSize(
        expectedCount = 0,
        message = message
    )
}