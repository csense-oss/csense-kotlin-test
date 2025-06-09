package org.csenseoss.kotlin.tests.assertions.general

import org.csenseoss.kotlin.annotations.numbers.limit.*
import org.csenseoss.kotlin.tests.assertions.comparable.*
import org.csenseoss.kotlin.tests.assertions.texts.*


/**
 * Asserts that the given [action] calls the callback function [times] times otherwise fails with the given [message]
 * @param message [String] the error message if it fails (times the callback called != times)
 * @param times [Int] the number of times we expected the callback to be called
 * @param action the action, getting the callback function
 */
public inline fun assertCalled(
    message: String = GeneralStrings.assertCalledMessage,
    @IntLimit(from = 1) times: Int = 1,
    action: (shouldBeCalled: () -> Unit) -> Unit
) {
    var counter = 0
    action { counter += 1 }
    counter.assert(times, message)
}

/**
 * Asserts that the given [action] calls the callback function 1 times otherwise fails with the given [message]
 * @param message [String] the error message if it fails (times the callback called != 1)
 * @param action the action, getting the callback function
 */
public inline fun assertCalled(
    message: String = GeneralStrings.assertCalledMessage,
    action: (shouldBeCalled: () -> Unit) -> Unit
): Unit = assertCalled(message, 1, action)