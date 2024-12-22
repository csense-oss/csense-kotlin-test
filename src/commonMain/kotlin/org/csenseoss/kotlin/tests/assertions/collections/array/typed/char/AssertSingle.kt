package org.csenseoss.kotlin.tests.assertions.collections.array.typed.char

import org.csenseoss.kotlin.tests.assertions.*
import kotlin.test.*

/**
 * Asserts that this array contains the only given item
 * @param item Char the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun CharArray?.assertSingle(item: Char, message: String = "") {
    assertNotNull()
    assertSize(1, message = "Should have 1 item")
    assertEquals(item, first(), message)
}