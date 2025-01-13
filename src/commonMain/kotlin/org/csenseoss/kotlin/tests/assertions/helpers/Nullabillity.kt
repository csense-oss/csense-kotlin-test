@file:Suppress("NOTHING_TO_INLINE")

package org.csenseoss.kotlin.tests.assertions.helpers

import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.contracts.*


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

    public inline fun <T, U> assertNullabillityEquals(
        actual: T?,
        expected: U?
    ) {
        if (actual == null && expected != null || actual != null && expected == null) {
            failTest("Nullability difference between \"$actual\" and \"$expected\"")
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

    public inline fun <reified T> assertNullabillityContinueOnNotNull(
        first: T?,
        second: T?,
        returnFunction: () -> Nothing
    ) {
        contract { returns() implies (first != null && second != null) }
        if (first == null && second == null) {
            returnFunction()
        }
        if (first != null && second == null || first == null && second != null) {
            failTest("")
        }
    }
}