package org.csenseoss.kotlin.tests.assertions.collections.array.typed.long

import org.csenseoss.kotlin.tests.assertions.comparable.*
import org.csenseoss.kotlin.tests.assertions.general.*


/**
 * Asserts that this array contains the only given item
 * @param item Long the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun LongArray?.assertSingle(item: Long, message: String = "") {
    assertNotNull()
    assertSize(1, message = "Should have 1 item")
    first().assert(expected = item, message = message)
}