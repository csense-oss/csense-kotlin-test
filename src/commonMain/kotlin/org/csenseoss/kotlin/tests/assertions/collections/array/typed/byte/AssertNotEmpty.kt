@file:Suppress("NOTHING_TO_INLINE")
package org.csenseoss.kotlin.tests.assertions.collections.array.typed.byte

import org.csenseoss.kotlin.tests.assertions.comparable.*


public inline fun ByteArray.assertNotEmpty(
    message: String = "Expected this to have content, but has is empty"
) {
    size.assertLargerOrEqualTo(expected = 1, message = message)
}