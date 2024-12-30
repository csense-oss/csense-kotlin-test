package org.csenseoss.kotlin.tests.assertions.primitives.charSequence

import org.csenseoss.kotlin.tests.assertions.general.*
import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*

/**
 * Asserts that this string is empty (length == 0)
 * @receiver String the string to test for emptiness
 */
public fun CharSequence?.assertEmpty(message: String = ""): Unit {
    this.assertNotNull()
    isEmpty().assertTrue("Expected string to be empty but was instead \"$this\".$message")
}