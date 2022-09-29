@file:Suppress("unused", "INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package csense.kotlin.tests.assertions

import csense.kotlin.annotations.numbers.*
import kotlin.contracts.*
import kotlin.test.*


/**
 * Asserts that the size of this collection is the given size
 * @receiver [Collection]<T>
 * @param size [Int]
 * @param message [String]
 */
public fun <T> Collection<T>.assertSize(@IntLimit(from = 0) size: Int, message: String = ""): Unit =
    this.size.assert(size, message)

/**
 * Asserts that the size of this collection is the given size, and if so, calls the given [action]
 * @receiver Collection<T>
 * @param size Int
 * @param message String
 * @param action Function1<Collection<T>, Unit>
 */
public inline fun <T> Collection<T>.assertSizeAnd(
    @IntLimit(from = 0) size: Int,
    message: String = "",
    action: Collection<T>.() -> Unit
) {
    assertSize(size, message)
    action()
}

/**
 * Asserts that this collection is empty
 * @receiver [Collection]<T>
 * @param message [String]
 */
public fun <T> Collection<T>.assertEmpty(message: String = "should be empty"): Unit = assertSize(0, message)

/**
 * Asserts that this collection has content
 * @receiver [Collection]<T>
 * @param message [String]
 */
public fun <T> Collection<T>.assertNotEmpty(message: String = "should have content"): Unit =
    this.size.assertLargerOrEqualTo(1, message)

/**
 * Asserts that the given list contains the given item
 * @receiver [List]<T>
 * @param item T
 * @param message [String]
 */
public fun <@kotlin.internal.OnlyInputTypes T> Collection<T>.assertContains(
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

public fun <@kotlin.internal.OnlyInputTypes T> Collection<T>.assertContainsAll(
    vararg items: T
): Unit = items.forEach { assertContains(it) }


public fun <@kotlin.internal.OnlyInputTypes T> Collection<T>.assertContainsAll(
    items: Iterable<T>
): Unit = items.forEach { assertContains(it) }

/**
 * Asserts that the given list does not contain the given item
 * @receiver [List]<T>
 * @param item T
 * @param message [String]
 */
public fun <@kotlin.internal.OnlyInputTypes T> Collection<T>.assertContainsNot(
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
public fun <@kotlin.internal.OnlyInputTypes T> Collection<T>.assertContainsNotAll(
    vararg items: T
): Unit = items.forEach { assertContainsNot(it) }

/**
 * Asserts that this collection's items are different from the given [items] (none are contained)
 * @receiver [Collection]<T>
 * @param items [Array]<out T>
 */
public fun <@kotlin.internal.OnlyInputTypes T> Collection<T>.assertContainsNotAll(
    items: Iterable<T>
): Unit = items.forEach { assertContainsNot(it) }

/**
 * Asserts that there is only 1 element (the given) in this list
 * @receiver [Collection]<T>
 * @param item T
 */
public fun <@kotlin.internal.OnlyInputTypes T> Collection<T>.assertSingle(item: T) {
    assertSize(1)
    assertEquals(item, first())
}

/**
 * asserts that there is a single item and if so invokes the [callback]
 * @receiver [Collection]<T>
 * @param callback (T) -> Unit
 */

public inline fun <@kotlin.internal.OnlyInputTypes T> Collection<T>.assertSingle(callback: (T) -> Unit) {
    contract {
        callsInPlace(callback, kind = InvocationKind.AT_MOST_ONCE)
    }
    assertSize(1)
    callback(first())
}

/**
 * Asserts that the content of this collection is the same as the given collection (same count, same items)
 * does not consider order important (instead see [assertContentAndOrder]
 * @receiver Collection<T>
 * @param
 */
public fun <T> Collection<T>.assertContent(expected: Collection<T>) where T : Comparable<T> {
    assertSize(expected)
    assertContainsAll(expected)
}

public fun <T> Collection<T>.assertContentAndOrder(expected: Collection<T>) where T : Comparable<T> {
    assertSize(expected)
    forEachIndexed { index, actual ->
        actual.assert(expected.elementAt(index))
    }
}

public fun <T> Collection<T>.assertSize(expected: Collection<T>) {
    this.size.assert(expected.size, message = "Should have item count, actual = $size expected size = ${expected.size}")
}
