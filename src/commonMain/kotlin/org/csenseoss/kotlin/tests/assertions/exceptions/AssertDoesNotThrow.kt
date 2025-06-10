package org.csenseoss.kotlin.tests.assertions.exceptions

/**
 * Simply "asserts" that the expectation is that no exceptions is thrown.
 * This serves as documentation purpose.
 */
public inline fun assertDoesNotThrow(throwingAction: () -> Unit) {
    throwingAction()
}