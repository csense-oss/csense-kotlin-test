package org.csenseoss.kotlin.tests.assertions.collections.array.typed.short

import org.csenseoss.kotlin.tests.assertions.*
import kotlin.test.*


/**
 * Asserts that this array contains the only given item
 * @param item Short the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun ShortArray?.assertSingle(item: Short, message: String = "") {
    assertNotNull()
    assertSize(1, message = "Should have 1 item")
    assertEquals(item, first(), message)
}