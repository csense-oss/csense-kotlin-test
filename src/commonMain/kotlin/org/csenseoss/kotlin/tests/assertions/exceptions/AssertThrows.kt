package org.csenseoss.kotlin.tests.assertions.exceptions

import org.csenseoss.kotlin.tests.assertions.general.*


/**
 * Asserts that the given [testCode] throws an exception of the given type [T]
 * @param message [String] the message to print if [testCode] does not throw
 * @param messageWrongException [String] the message if the exception is not same instance as [T]
 * @param testCode Function0<[Unit]> the action which should throw
 */
public inline fun <reified T : Throwable> assertThrows(
    message: String = "should throw",
    messageWrongException: String = "wrong exception type",
    crossinline testCode: () -> Unit
): Unit = assertThrows<T>(
    messageIfNoException = message,
    messageWrongException = messageWrongException,
    testCode = testCode,
    validateThrows = {}
)


/**
 * Asserts the given [testCode] throws an exception of Type [T] and afterwards validates the exception.
 * Useful if you want to inspect the exception (in [validateThrows])
 * @param messageIfNoException [String] the message to show if no exception gets thrown
 * @param messageWrongException [String] the message to show if the thrown exception differs from [T]
 * @param testCode Function0<Unit> the action that should throw an exception of type [T]
 * @param validateThrows Function1<T, Unit> validates that [T] is in an expected state.
 */
public inline fun <reified T : Throwable> assertThrows(
    messageIfNoException: String = "should throw",
    messageWrongException: String = "wrong exception type",
    crossinline testCode: () -> Unit,
    validateThrows: (T) -> Unit
) {

    var didCatchException = false
    try {
        testCode()
    } catch (exception: Throwable) {
        if (exception !is T) {
            failTest(
                "Expected an exception of type \"${T::class}\" " +
                        "but got exception of type \"${exception::class}\" instead." +
                        "\n$messageWrongException"
            )
        }
        didCatchException = true
        validateThrows(exception)
        //all is good / expected.
    }
    if (!didCatchException) {
        failTest("Expected an exception of type ${T::class} but got no exceptions\n$messageIfNoException")
    }
}