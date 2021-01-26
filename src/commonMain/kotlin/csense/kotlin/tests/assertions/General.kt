@file:Suppress("unused", "NOTHING_TO_INLINE", "MissingTestFunction")

package csense.kotlin.tests.assertions

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
import kotlin.test.*

/**
 * As the name suggest, calling this means failure.
 */
public inline fun shouldNotBeCalled(): Nothing {
    fail(GeneralStrings.assertNotCalledMessage)
}

/**
 * fails the test with the given message
 * @param message String
 */
public inline fun failTest(message: String = ""): Nothing {
    fail(message)
}

/**
 * Assert this is the same as type as [otherValue] and that they are equal
 * @receiver [Any]
 * @param otherValue T the value this receiver should be (both type and equals)
 * @param message [String] if they are different this will be printed (nb if they are different type another message will be printed).
 */
@OptIn(ExperimentalContracts::class)
public inline fun <reified T> Any.assertAs(
    otherValue: T,
    message: String = "value of \"$this\" is not the expected \"$otherValue\""
) {
    contract {
        returns() implies (this@assertAs is T)
    }
    @Suppress("UNCHECKED_CAST") //this is expected
    this.assertIs<T>() //make sure that if the type is not the same then we get that error message.
    // we are just making life easier for testing, if it throws, then its "all right" for a test.
    assertEquals(this as? T, otherValue, message)
}

/**
 * Assert this is the given type
 * @receiver [Any] the receiver we are testing is the same type as [T]
 * @param message [String] the message to print if the receiver is a different type from [T]
 */
@OptIn(ExperimentalContracts::class)
public inline fun <reified T> Any.assertIs(
    message: String = "expected `$this` to be of type `${T::class}`, but it is not"
) {
    contract {
        returns() implies (this@assertIs is T)
    }
    assertTrue(this is T, message)
}

/**
 * Asserts this is not null (and if it is not, then kotlin smart casts it to a notnull variable)
 * @receiver [Any]? the value to assert is not null
 * @param message [String] the message that gets printed if this is null
 */
@OptIn(ExperimentalContracts::class)
public inline fun Any?.assertNotNull(message: String = "") {
    contract {
        returns() implies (this@assertNotNull != null)
    }
    assertNotNull(this, message)
}

/**
 * Asserts this is null (and if it is null, then kotlin smart casts it to a null variable)
 * @receiver [Any]?
 * @param message [String]
 */
@OptIn(ExperimentalContracts::class)
public inline fun Any?.assertNull(message: String = "") {
    contract {
        returns() implies (this@assertNull == null)
    }
    assertNull(this, message)
}

/**
 * Asserts this is not null and if not then applies the given [action] on it
 * @receiver T? the nullable element
 * @param message [String] the message to display if the receiver is null
 * @param action Function1<T, Unit> the receiver action  to run if the receiver is not null
 */
@OptIn(ExperimentalContracts::class)
public inline fun <T> T?.assertNotNullApply(message: String = "", action: T.() -> Unit) {
    contract {
        returns() implies (this@assertNotNullApply != null)
    }
    this.assertNotNull(message)
    this.let(action)
}

/**
 * Asserts this is not null and equals the [other] object
 * @receiver T? the object to make sure is not null and equals [other]
 * @param other T? the value it should be (the expected)
 * @param message [String] the message to display if the receiver does not match the expected.
 */
@OptIn(ExperimentalContracts::class)
public inline fun <T> T?.assertNotNullAndEquals(other: T?, message: String = "value was $this, expected $other") {
    contract {
        returns() implies (this@assertNotNullAndEquals != null)
    }
    this.assertNotNull()
    assertEquals(other, this, message)
}

/**
 * Asserts the given [action] throws the given exception type.
 * @param messageIfNoException [String] the message to show if either no exception or a different type of exception gets thrown
 * @param messageWrongException [String]
 * @param action Function0<[Unit]>
 */
public inline fun <reified T : Throwable, reified Inner : Throwable> assertThrowsCause(
    messageIfNoException: String = "should throw exception",
    messageWrongException: String = "wrong exception type",
    crossinline action: () -> Unit
): Unit = assertThrows<T>(messageIfNoException, messageWrongException, action) {
    val cause = it.cause
    val isInner = cause is Inner
    if (!isInner && cause != null) {
        failTest("Cause is not the right type; expected \"${Inner::class}\" but got \"${cause::class}\" instead")
    }
}

/**
 * Asserts that the given [action] throws an exception of the given type [T]
 * @param message [String] the message to print if [action] does not throw
 * @param messageWrongException [String] the message if the exception is not same instance as [T]
 * @param action Function0<[Unit]> the action which should throw
 */
public inline fun <reified T : Throwable> assertThrows(
    message: String = "should throw",
    messageWrongException: String = "wrong exception type",
    crossinline action: () -> Unit
): Unit = assertThrows<T>(message, messageWrongException, action, {})

/**
 * Asserts the given [action] throws an exception of Type [T] and afterwards validates the exception.
 * Useful if you want to inspect the exception (in [validateThrows])
 * @param messageIfNoException [String] the message to show if no exception gets thrown
 * @param messageWrongException [String] the message to show if the thrown exception differs from [T]
 * @param action Function0<Unit> the action that should throw an exception of type [T]
 * @param validateThrows Function1<T, Unit> validates that [T] is in an expected state.
 */
public inline fun <reified T : Throwable> assertThrows(
    messageIfNoException: String = "should throw",
    messageWrongException: String = "wrong exception type",
    crossinline action: () -> Unit,
    validateThrows: (T) -> Unit
) {

    try {
        action()
        failTest("Expected an exception of type ${T::class} but got no exceptions\n$messageIfNoException")
    } catch (exception: Throwable) {
        if (exception !is T) {
            failTest(
                "Expected an exception of type \"${T::class}\" " +
                        "but got exception of type \"${exception::class}\" instead." +
                        "\n$messageWrongException"
            )
        }
        validateThrows(exception)
        //all is good / expected.
    }
}

/**
 * Asserts that the given [action] calls the callback function [times] times otherwise fails with the given [message]
 * @param message [String] the error message if it fails (times the callback called != times)
 * @param times [Int] the number of times we expected the callback to be called
 * @param action the action, getting the callback function
 */
public inline fun assertCalled(
    message: String = GeneralStrings.assertCalledMessage,
    times: Int = 1,
    action: (callback: () -> Unit) -> Unit
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
    action: (callback: () -> Unit) -> Unit
): Unit = assertCalled(message, 1, action)

/**
 * Asserts that the given [action] calls the callback function 0 times / not gets called.
 * Otherwise fails with the given [message]
 * @param message [String]  the error message if it gets called
 * @param action the action that should not be invoked.(assertion)
 */
public inline fun assertNotCalled(
    message: String = GeneralStrings.assertNotCalledMessage,
    action: (callback: () -> Unit) -> Unit
): Unit = assertCalled(message, 0, action)

public object GeneralStrings {
    public const val assertCalledMessage: String = "Should be called, but did not get called enough times"
    public const val assertNotCalledMessage: String = "Should not be called but got called anyway"
}