@file:Suppress("unused", "INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package csense.kotlin.tests.assertions

import csense.kotlin.annotations.numbers.*
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
import kotlin.test.*

/**
 * As the name suggest, calling this means failure.
 */
public fun shouldNotBeCalled(): Nothing {
    fail(GeneralStrings.assertNotCalledMessage)
}

/**
 * fails the test with the given message
 * @param message String
 */
public fun failTest(message: String = ""): Nothing {
    fail(message)
}

/**
 * Assert this is the same as type as [otherValue] and that they are equal
 * @receiver [Any]
 * @param otherValue T the value this receiver should be (both type and equals)
 * @param message [String] if they are different this will be printed (nb if they are different type another message will be printed).
 */

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

public inline fun <reified T> Any.assertIs(
    message: String = "expected `$this` of type `${this::class.simpleName}`  to be of type `${T::class}`, but it is not",
) {
    contract {
        returns() implies (this@assertIs is T)
    }
    assertTrue(this is T, message)
}

/**
 * Assert this is the given type
 * @receiver [Any] the receiver we are testing is the same type as [T]
 * @param message [String] the message to print if the receiver is a different type from [T]
 */
public inline fun <reified T> Any.assertIsApply(
    message: String = "expected `$this` of type `${this::class.simpleName}`  to be of type `${T::class}`, but it is not",
    andAction: T.() -> Unit
) {
    contract {
        returns() implies (this@assertIsApply is T)
    }
    assertTrue(this is T, message)
    andAction(this)
}

/**
 * Asserts this is not null (and if it is not, then kotlin smart casts it to a notnull variable)
 * @receiver [Any]? the value to assert is not null
 * @param message [String] the message that gets printed if this is null
 */
public fun Any?.assertNotNull(message: String = "") {
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

public fun Any?.assertNull(message: String = "") {
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

public inline fun <T> T?.assertNotNullApply(message: String = "", action: T.() -> Unit) {
    contract {
        returns() implies (this@assertNotNullApply != null)
    }
    this.assertNotNull(message)
    this.let(action)
}

/**
 * Asserts this is not null and equals the [expected] object
 * @receiver T? the object to make sure is not null and equals [expected]
 * @param expected T? the value it should be (the expected)
 * @param message [String] the message to display if the receiver does not match the expected.
 */
@Deprecated("Use regular assert. ", replaceWith = ReplaceWith("this.assert(other, message)"))

public fun <@kotlin.internal.OnlyInputTypes T> T?.assertNotNullAndEquals(
    expected: T?,
    message: String = "value was $this, expected $expected"
) {
    contract {
        returns() implies (this@assertNotNullAndEquals != null)
    }
    this.assertNotNull()
    assertEquals(expected, this, message)
}


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

/**
 * Asserts that the given [action] calls the callback function 0 times / not gets called.
 * Otherwise fails with the given [message]
 * @param message [String]  the error message if it gets called
 * @param action the action that should not be invoked.(assertion)
 */
public inline fun assertNotCalled(
    message: String = GeneralStrings.assertNotCalledMessage,
    action: (shouldNotBeCalled: () -> Unit) -> Unit
): Unit = assertCalled(message, 0, action)

/**
 * Asserts that the given [testCode] will have the given items in order (and called that exact amount of times)
 * @param expectedItemsInOrder Iterable<T>
 * @param testCode Function1<Function1<T, Unit>, Unit>
 */
public inline fun <reified T> assertCallbackCalledWith(
    expectedItemsInOrder: Collection<T>,
    testCode: ((T) -> Unit) -> Unit
) where T : Comparable<T> {
    assertCallbackCalledWith(expectedItemsInOrder, assertFunction = { lhs, rhs ->
        lhs == rhs
    }, testCode)
}

/**
 * Asserts that the given [testCode] will have the given items in order (and called that exact amount of times)
 * @param expectedItemsInOrder Collection<T>
 * @param assertFunction Function2<T, T, Boolean>
 * @param testCode Function1<Function1<T, Unit>, Unit>
 */
public inline fun <reified T> assertCallbackCalledWith(
    expectedItemsInOrder: Collection<T>,
    crossinline assertFunction: (T, T) -> Boolean,
    testCode: ((T) -> Unit) -> Unit,
): Unit = assertCalled(times = expectedItemsInOrder.size) { shouldBeCalled ->
    val iterator = expectedItemsInOrder.iterator()
    val callback: (T) -> Unit = { actual: T ->
        if (!iterator.hasNext()) {
            failTest(
                "Tried to access next element but was not in the expectedItemsInOrder." +
                        " You have called the assert function more than ${expectedItemsInOrder.size} times"
            )
        }
        val expected = iterator.next()
        val isEqual = assertFunction(actual, expected)
        if (isEqual.not()) {
            failTest("Expected \"$actual\" to be \"$expected\"")
        }
        shouldBeCalled()
    }
    testCode(callback)
}

/**
 * Asserts that this is equal to expected
 */
public fun <@kotlin.internal.OnlyInputTypes T> T.assertByEquals(
    expected: T?,
    optMessage: String? = null
) {
    val isEqual = this?.equals(expected) == true
    isEqual.assertTrue(
        message = "Expected $this to be equal (via equals) to $expected. ${optMessage ?: ""}"
    )
}


public object GeneralStrings {
    public const val assertCalledMessage: String = "Should be called, but did not get called enough times"
    public const val assertNotCalledMessage: String = "Should not be called but got called anyway"
}