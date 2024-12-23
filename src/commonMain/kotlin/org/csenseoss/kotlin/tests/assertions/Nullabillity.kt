package org.csenseoss.kotlin.tests.assertions

import org.csenseoss.kotlin.tests.assertions.general.*


public object Nullabillity {
    public inline fun <T, U> assertNullabillityEqualsOr(
        actual: T?,
        expected: U?,
        orByAssert: (T, U) -> Unit,
        message: String = "Expected both \"$actual\" and \"$expected\" to be equal"
    ) {
        if (actual != null && expected != null) {
            orByAssert(actual, expected)
            return
        }
        val isEqual: Boolean = actual == null && expected == null
        if (!isEqual) {
            failTest(message)
        }
    }
    public inline fun <T, U> assertNullabillityNotEqualsOr(
        actual: T?,
        expected: U?,
        orByAssert: (T, U) -> Unit,
        message: String = "Expected \"$actual\" and \"$expected\" to be different"
    ) {
        if (actual != null && expected != null) {
            orByAssert(actual, expected)
            return
        }
        val isEqual: Boolean = actual == null && expected == null
        if (isEqual) {
            failTest(message)
        }
    }
}