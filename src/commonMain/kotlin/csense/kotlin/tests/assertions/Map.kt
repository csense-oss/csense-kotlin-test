@file:Suppress("unused")

package csense.kotlin.tests.assertions

import csense.kotlin.annotations.numbers.*
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
public fun Map<*, *>.assertSize(
    @IntLimit(from = 0) expectedSize: Int,
    message: String = "Expected the map to have a size of $expectedSize, but it is instead ${this.size}"
): Unit =
    this.size.assert(expectedSize, message)

/**
 * Asserts that this map is empty.
 * @receiver [Map]<*, *>
 * @param message [String] the message if this map's size differs from empty
 */
public fun Map<*, *>.assertEmpty(
    message: String = "Map should be empty but is not."
): Unit =
    this.isEmpty().assertTrue(message)

/**
 * Asserts that this map has content
 * @receiver [Map]<*, *>
 * @param message [String] the message if this map's size is 0 / is Empty
 */
public fun Map<*, *>.assertNotEmpty(
    message: String = "Map should have content"
): Unit =
    this.isNotEmpty().assertTrue(message)

/**
 * Asserts this map only contains 1 element (the given [item])
 * @receiver [Map]<Key, Value>
 * @param item [Map.Entry]<Key, Value>
 * @param message String
 */
public fun <Key, Value> Map<Key, Value>.assertSingle(item: Map.Entry<Key, Value>, message: String = "") {
    assertSize(1, "should have single item. $message")
    assertEquals(item, entries.first())
}

/**
 * Asserts this map only contains 1 element (the given [keyValue])
 * @receiver [Map]<Key, Value>
 * @param keyValue [Map.Entry]<Key, Value>
 * @param messageForSize String
 */
public inline fun <Key, reified Value> Map<Key, Value>.assertSingle(
    keyValue: Pair<Key, Value>,
    messageForSize: String = ""
) {
    assertSize(1, "should have single item. $messageForSize")
    val value = get(keyValue.first)
    value.assertNotNull("Could not find key \"${keyValue.first}\"")
    value.assertAs(keyValue.second)
}

/**
 * Asserts this map only contains 1 element and if so invokes the given [callback]
 * @receiver [Map]<Key, Value>
 * @param callback Function1<[Map.Entry]<Key, Value>, Unit>
 */

public inline fun <Key, Value> Map<Key, Value>.assertSingle(callback: (Map.Entry<Key, Value>) -> Unit) {
    contract {
        callsInPlace(callback, kind = InvocationKind.AT_MOST_ONCE)
    }
    assertSize(1, "should have single item.")
    callback(entries.first())
}

/**
 * asserts that the given [key] is in this [Map]
 * @receiver [Map]<Key, Value>
 * @param key [Key] the key to test for
 */
public fun <Key, Value> Map<Key, Value>.assertContainsKey(key: Key) {
    containsKey(key).assertTrue()
}

/**
 * asserts that the given [key] is missing from this [Map]
 * @receiver [Map]<Key, Value>
 * @param key [Key] the key to test whenever is missing
 */
public fun <Key, Value> Map<Key, Value>.assertDoesNotContainsKey(key: Key) {
    containsKey(key).assertFalse()
}

/**
 * Asserts that this [Map] contains the given [Map.Entry] (by key and then by value)
 * @receiver [Map]<Key, Value>
 * @param entry [Map.Entry]<Key, Value> the entry to assert exists
 */
public inline fun <Key, reified Value> Map<Key, Value>.assertContains(
    entry: Map.Entry<Key, Value>
) {
    val value = get(entry.key)
    value.assertNotNull("key \"${entry.key}\" not found in ($keys)")
    value.assertAs(entry.value)
}

/**
 * Asserts that this [Map] contains the given [Pair] (by key then value)
 * @receiver [Map]<Key, Value>
 * @param keyValue [Pair]<Key, Value> the key to find and then the value to assert
 */
public inline fun <Key, reified Value> Map<Key, Value>.assertContains(
    keyValue: Pair<Key, Value>
) {
    val value = get(keyValue.first)
    value.assertNotNull("key \"${keyValue.first}\" not found in ($keys)")
    value.assertAs(keyValue.second)
}

/**
 * Asserts that this [Map] contains the given key and runs the given [ifFoundAction]
 * @receiver Map<Key, Value>
 * @param key [Key] the key to search for
 * @param ifFoundAction Function1<Value, Unit> the function to execute if the key was found
 */
public inline fun <Key, reified Value> Map<Key, Value>.assertContainsKeyAnd(
    key: Key,
    ifFoundAction: (Value) -> Unit
) {
    val value = get(key)
    value.assertNotNull("key \"$key\" not found in ($keys)")
    ifFoundAction(value)
}