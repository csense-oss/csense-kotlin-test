@file:Suppress("unused", "INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package org.csenseoss.kotlin.tests.assertions

import org.csenseoss.kotlin.annotations.numbers.*
import kotlin.contracts.*
import kotlin.test.*






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