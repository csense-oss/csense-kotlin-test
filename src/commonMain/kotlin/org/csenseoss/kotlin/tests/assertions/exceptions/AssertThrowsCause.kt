package org.csenseoss.kotlin.tests.assertions.exceptions

import org.csenseoss.kotlin.tests.assertions.general.*

/**
 * Asserts the given [testCode] throws the given exception type.
 * @param messageIfNoException [String] the message to show if either no exception or a different type of exception gets thrown
 * @param messageWrongException [String] the message to show if the type of the thrown exception does not match [Inner]
 * @param testCode Function0<[Unit]> the code to test
 */
public inline fun <reified T : Throwable, reified Inner : Throwable> assertThrowsCause(
    messageIfNoException: String = "should throw exception",
    messageWrongException: String = "wrong exception type",
    crossinline testCode: () -> Unit
): Unit = assertThrows<T>(messageIfNoException, messageWrongException, testCode) { it: T ->
    val cause: Throwable? = it.cause
    val isInner: Boolean = cause is Inner
    if (!isInner && cause != null) {
        failTest(message = "Cause is not the right type; expected \"${Inner::class}\" but got \"${cause::class}\" instead")
    }
}