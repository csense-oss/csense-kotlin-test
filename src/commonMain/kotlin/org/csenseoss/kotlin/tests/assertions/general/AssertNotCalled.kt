package org.csenseoss.kotlin.tests.assertions.general

import org.csenseoss.kotlin.tests.assertions.texts.*


/**
 * Asserts that the given [action] calls the callback function 0 times / not gets called.
 * Otherwise fails with the given [message]
 * @param message [String]  the error message if it gets called
 * @param action the action that should not be invoked.(assertion)
 */
public inline fun assertNotCalled(
    message: String = GeneralStrings.assertNotCalledMessage,
    action: (shouldNotBeCalled: () -> Unit) -> Unit
): Unit = assertCalled(
    message = message,
    times = 0,
    action = action
)