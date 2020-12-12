@file:Suppress("unused", "NOTHING_TO_INLINE", "MissingTestFunction")

package csense.kotlin.tests.assertions

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.test.assertEquals

/**
 * Assert that this map have the given size.
 * @receiver [Map]<*, *>
 * @param expectedSize [Int] the expected size of this map
 * @param message [String] the message if this map's size differs from the [expectedSize]
 */
public inline fun Map<*, *>.assertSize(
    expectedSize: Int,
    message: String = "Expected the map to have a size of $expectedSize, but it is instead ${this.size}"
): Unit =
    this.size.assert(expectedSize, message)

/**
 * Asserts that this map is empty.
 * @receiver [Map]<*, *>
 * @param message [String] the message if this map's size differs from empty
 */
public inline fun Map<*, *>.assertEmpty(
    message: String = "Map should be empty but is not."
): Unit =
    this.isEmpty().assertTrue(message)

/**
 * Asserts this map only contains 1 element (the given [item])
 * @receiver [Map]<K, V>
 * @param item [Map.Entry]<K, V>
 * @param message String
 */
public inline fun <K, V> Map<K, V>.assertSingle(item: Map.Entry<K, V>, message: String = "") {
    assertSize(1, "should have single item. $message")
    assertEquals(item, entries.first())
}

/**
 * Asserts this map only contains 1 element and if so invokes the given [callback]
 * @receiver [Map]<K, V>
 * @param callback Function1<[Map.Entry]<K, V>, Unit>
 */
@OptIn(ExperimentalContracts::class)
public inline fun <K, V> Map<K, V>.assertSingle(callback: (Map.Entry<K, V>) -> Unit) {
    contract {
        callsInPlace(callback, kind = InvocationKind.AT_MOST_ONCE)
    }
    assertSize(1)
    callback(entries.first())
}