package csense.kotlin.tests.assertions


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
): Unit = assertThrows<T>(messageIfNoException, messageWrongException, testCode) {
    val cause = it.cause
    val isInner = cause is Inner
    if (!isInner && cause != null) {
        failTest("Cause is not the right type; expected \"${Inner::class}\" but got \"${cause::class}\" instead")
    }
}

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
): Unit = assertThrows<T>(message, messageWrongException, testCode, validateThrows = {})

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

public fun Throwable?.assert(expected: Throwable, message: String = "") {
    if (this == null) {
        failTest("Expected $expected but got null;$message")
    }
    if (this::class != expected::class) {
        failTest("Mismatching types. Expected $expected but got $this;$message")
    }
    val otherMessage = expected.message
    if (otherMessage != null) {
        this.message.assert(otherMessage, message)
    } else {
        this.message.assertNull()
    }
    val otherCause = expected.cause
    if (otherCause != null) {
        this.cause.assert(otherCause, message)
    } else {
        this.cause.assertNull()
    }
}