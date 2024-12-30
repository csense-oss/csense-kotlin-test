package org.csenseoss.kotlin.tests.assertions.collections.array.typed.int

import org.csenseoss.kotlin.tests.assertions.comparable.*
import org.csenseoss.kotlin.tests.assertions.general.*


/**
 * Asserts that this array contains the only given item
 * @param item Int the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun IntArray?.assertSingle(item: Int, message: String = "") {
    assertNotNull()
    assertSize(size = 1, message = "Should have 1 item")
    first().assert(expected = item, message = message)
}