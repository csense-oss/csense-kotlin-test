package org.csenseoss.kotlin.tests.assertions.primitives.string

import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*

/**
 * Asserts that this string is not empty (length > 0)
 * @receiver String the string to test for fullness
 */
public fun String.assertNotEmpty(
    message: String = ""
): Unit = isNotEmpty().assertTrue(message = "Expected string to not be empty but it was.$message")