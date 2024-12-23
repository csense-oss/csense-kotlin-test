package org.csenseoss.kotlin.tests.assertions.primitives.byte

import kotlin.test.*


public fun Byte.assertNot(
    value: Byte,
    message: String = ""
): Unit {
    val errorMessage = "Expected $value to be different from $this but they are the same."
    assertNotEquals(value, this, errorMessage + message)
}