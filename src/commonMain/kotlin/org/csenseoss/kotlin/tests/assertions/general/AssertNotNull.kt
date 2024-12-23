package org.csenseoss.kotlin.tests.assertions.general

import kotlin.contracts.*


/**
 * Asserts this is not null (and if it is not, then kotlin smart casts it to a notnull variable)
 * @receiver [Any]? the value to assert is not null
 * @param message [String] the message that gets printed if this is null
 */
public fun Any?.assertNotNull(message: String = "") {
    contract {
        returns() implies (this@assertNotNull != null)
    }
    kotlin.test.assertNotNull(this, message)
}

@Suppress("UnusedReceiverParameter", "DeprecatedCallableAddReplaceWith")
@Deprecated(
    "Asserting compile time known notnull value to be not null is an error",
    level = DeprecationLevel.ERROR
)
public fun Any.assertNotNull(
    message: String = ""
): Nothing = failTest(message)