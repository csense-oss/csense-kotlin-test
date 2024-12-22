package org.csenseoss.kotlin.tests.assertions.collections.array.typed.int

import org.csenseoss.kotlin.tests.assertions.*
import kotlin.test.*


/**
 * Asserts that this array contains the only given item
 * @param item Int the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun IntArray?.assertSingle(item: Int, message: String = "") {
    assertNotNull()
    assertSize(1, message = "Should have 1 item")
    assertEquals(item, first(), message)
}