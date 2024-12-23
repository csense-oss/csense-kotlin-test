package org.csenseoss.kotlin.tests.assertions.general

import kotlin.test.*

/**
 * fails the test with the given message
 * @param message String
 */
public fun failTest(message: String = ""): Nothing {
    fail(message)
}