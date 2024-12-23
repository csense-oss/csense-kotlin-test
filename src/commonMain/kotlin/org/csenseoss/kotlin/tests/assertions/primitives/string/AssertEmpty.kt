package org.csenseoss.kotlin.tests.assertions.primitives.string

import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*

/**
 * Asserts that this string is empty (length == 0)
 * @receiver String the string to test for emptiness
 */
public fun String.assertEmpty(message: String = ""): Unit =
    isEmpty().assertTrue("Expected string to be empty but was instead \"$this\".$message")