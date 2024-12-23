package org.csenseoss.kotlin.tests.assertions.general

import org.csenseoss.kotlin.tests.assertions.*
import kotlin.contracts.*
import kotlin.test.*


/**
 * Assert this is the given type
 * @receiver [Any] the receiver we are testing is the same type as [T]
 * @param message [String] the message to print if the receiver is a different type from [T]
 */

public inline fun <reified T> Any?.assertIs(
    message: String = "expected \"$this\" of type \"${this.helpers.simpleClassNameOrDash()}\" to be of type \"${T::class}\", but is not",
) {
    contract {
        returns() implies (this@assertIs is T)
    }
    assertTrue(actual = this is T, message = message)
}