package org.csenseoss.kotlin.tests.assertions.comparable

import kotlin.test.*

/**
 * Asserts that this comparable is different from [different]
 * @receiver [Comparable]<T> the receiver / actual
 * @param different Enum<T> the value we are expecting this to be different from
 * @param message [String] a message if they are the same
 */
public fun <T : Comparable<T>> T.assertNot(
    different: T,
    message: String? = "Expected $this to be different from $different but they are the same"
): Unit = assertNotEquals(different, this, message)