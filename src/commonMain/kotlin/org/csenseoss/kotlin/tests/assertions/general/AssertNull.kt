package org.csenseoss.kotlin.tests.assertions.general

import kotlin.contracts.*


/**
 * Asserts this is null (and if it is null, then kotlin smart casts it to a null variable)
 * @receiver [Any]?
 * @param message [String]
 */

public fun Any?.assertNull(message: String = "") {
    contract {
        returns() implies (this@assertNull == null)
    }
    kotlin.test.assertNull(this, message)
}

@Suppress("UnusedReceiverParameter", "DeprecatedCallableAddReplaceWith")
@Deprecated(
    "Asserting compile time known notnull value to be null is an error",
    level = DeprecationLevel.ERROR
)
public fun Any.assertNull(message: String = ""): Nothing = failTest(message)