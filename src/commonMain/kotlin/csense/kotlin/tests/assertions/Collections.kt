@file:Suppress("unused", "NOTHING_TO_INLINE", "MissingTestFunction")

package csense.kotlin.tests.assertions

import kotlin.test.assertEquals

/**
 * Asserts that the size of this array is the given size.
 * @receiver [Array]<T>
 * @param size [Int]
 * @param message [String]
 */
public inline fun <T> Array<T>.assertSize(size: Int, message: String = ""): Unit = this.size.assert(size, message)

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
 * Asserts that this list is empty.
 * @receiver [List]<*>
 * @param message [String]
 */
public inline fun List<*>.assertEmpty(message: String = ""): Unit = assertSize(0, message)

/**
 * Asserts that this list is the given size.
 * @receiver [List]<*>
 * @param size [Int]
 * @param message [String]
 */
public inline fun List<*>.assertSize(size: Int, message: String = ""): Unit = assertEquals(size, this.size, message)

/**
 * Asserts that the given list contains the given item
 * @receiver [List]<T>
 * @param item T
 * @param message [String]
 */
public inline fun <T> Collection<T>.assertContains(
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
public inline fun <T> Collection<T>.assertContainsAll(
    vararg items: T
): Unit = items.forEach { assertContains(it) }

/**
 * Asserts that the given list does not contain the given item
 * @receiver [List]<T>
 * @param item T
 * @param message [String]
 */
public inline fun <T> Collection<T>.assertContainsNot(
    item: T,
    message: String = "Should not contain $item"
) {
    contains(item).assertFalse(message)
}
/**
 *
 * @receiver [Collection]<T>
 * @param items [Array]<out T>
 */
public inline fun <T> Collection<T>.assertContainsNotAll(
    vararg items: T
): Unit = items.forEach { assertContainsNot(it) }
