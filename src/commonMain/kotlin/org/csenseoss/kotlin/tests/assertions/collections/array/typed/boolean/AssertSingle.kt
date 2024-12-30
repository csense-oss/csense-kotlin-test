package org.csenseoss.kotlin.tests.assertions.collections.array.typed.boolean

import org.csenseoss.kotlin.tests.assertions.general.*
import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*
import kotlin.contracts.*


/**
 * Asserts that this array contains the only given item
 * @param expected Boolean the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun BooleanArray?.assertSingle(
    expected: Boolean,
    message: String = ""
) {
    contract { returns() implies (this@assertSingle != null) }
    assertNotNull()
    assertSize(1, message = "Should have 1 item")
    first().assert(value = expected, message = message)
}