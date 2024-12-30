@file:Suppress("NOTHING_TO_INLINE")
package org.csenseoss.kotlin.tests.assertions.collections.iterable

import org.csenseoss.kotlin.tests.assertions.comparable.*
import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.contracts.*


public inline fun Iterable<*>?.assertSize(
    expectedCount: Int,
    message: String = "Expected $expectedCount size but was ${this?.count()}"
) {
    contract { returns() implies (this@assertSize != null) }
    this.assertNotNull()
    count().assert(
        expected = expectedCount,
        message = message
    )
}

public inline fun <T> Iterable<T>?.assertSize(
    expectedIterable: Iterable<T>,
    message: String = "expected size = ${expectedIterable.count()},actual = ${this?.count()}"
) {
    contract { returns() implies (this@assertSize != null) }
    this.assertNotNull()
    val actual: Int = count()
    val expected: Int = expectedIterable.count()
    actual.assert(expected = expected, message = message)
}