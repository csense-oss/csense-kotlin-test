@file:Suppress("unused", "NOTHING_TO_INLINE", "INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package csense.kotlin.tests.assertions

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.test.assertEquals


/**
 * Asserts that the size of this collection is the given size
 * @receiver [Collection]<T>
 * @param size [Int]
 * @param message [String]
 */
public inline fun <T> Collection<T>.assertSize(size: Int, message: String = ""): Unit = this.size.assert(size, message)

/**
 * Asserts that this collection is empty
 * @receiver [Collection]<T>
 * @param message [String]
 */
public inline fun <T> Collection<T>.assertEmpty(message: String = ""): Unit = assertSize(0, message)

/**
 * Asserts that the given list contains the given item
 * @receiver [List]<T>
 * @param item T
 * @param message [String]
 */
public inline fun <@kotlin.internal.OnlyInputTypes T> Collection<T>.assertContains(
    item: T,
    message: String = "Should contain $item"
) {
    contains(item).assertTrue(message)
}

/**
 *
 * @receiver [Collection]<T>
 * @param items [Array]<out T>
 */

public inline fun <@kotlin.internal.OnlyInputTypes T> Collection<T>.assertContainsAll(
    vararg items: T
): Unit = items.forEach { assertContains(it) }

/**
 * Asserts that the given list does not contain the given item
 * @receiver [List]<T>
 * @param item T
 * @param message [String]
 */
@Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")
public inline fun <@kotlin.internal.OnlyInputTypes T> Collection<T>.assertContainsNot(
    item: T,
    message: String = "Should not contain $item"
) {
    contains(item).assertFalse(message)
}

/**
 * Asserts that this collection's items are different from the given [items] (none are contained)
 * @receiver [Collection]<T>
 * @param items [Array]<out T>
 */
public inline fun <@kotlin.internal.OnlyInputTypes T> Collection<T>.assertContainsNotAll(
    vararg items: T
): Unit = items.forEach { assertContainsNot(it) }

/**
 * Asserts that there is only 1 element (the given) in this list
 * @receiver [Collection]<T>
 * @param item T
 */
public inline fun <@kotlin.internal.OnlyInputTypes T> Collection<T>.assertSingle(item: T) {
    assertSize(1)
    assertEquals(item, first())
}

/**
 * asserts that there is a single item and if so invokes the [callback]
 * @receiver [Collection]<T>
 * @param callback (T) -> Unit
 */
@OptIn(ExperimentalContracts::class)
public inline fun <@kotlin.internal.OnlyInputTypes T> Collection<T>.assertSingle(callback: (T) -> Unit) {
    contract {
        callsInPlace(callback, kind = InvocationKind.AT_MOST_ONCE)
    }
    assertSize(1)
    callback(first())
}