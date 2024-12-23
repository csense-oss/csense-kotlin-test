package org.csenseoss.kotlin.tests.assertions.collections.array.typed.byte


public inline fun ByteArray.assertEmpty(
    message: String = "Expected this to be empty, but has $size items"
) {
    assertSize(expected = 0, message = message)
}