package org.csenseoss.kotlin.tests.assertions.collections.map

import org.csenseoss.kotlin.tests.assertions.collections.map.entry.*
import kotlin.contracts.*


/**
 * Asserts this map only contains 1 element (the given [expected])
 * @receiver [Map]<Key, Value>
 * @param expected [Map.Entry]<Key, Value>
 * @param message String
 */
public fun <Key, Value> Map<Key, Value>.assertSingle(
    expected: Map.Entry<Key, Value>,
    message: String = ""
) where Key : Comparable<Key>, Value : Comparable<Value> {
    assertSize(expected = 1, message = "should have single item")
    entries.first().assert(expected = expected, message = message)
}

/**
 * Asserts this map only contains 1 element (the given [expected])
 * @receiver [Map]<Key, Value>
 * @param expected [Map.Entry]<Key, Value>
 * @param message String
 */
public inline fun <Key, reified Value> Map<Key, Value>.assertSingle(
    expected: Pair<Key, Value>,
    message: String = ""
) where Key : Comparable<Key>, Value : Comparable<Value> {
    assertSize(expected = 1, message = "should have single item")
    entries.first().assert(expected = expected, message = message)
}

/**
 * Asserts this map only contains 1 element and if so invokes the given [callback]
 * @receiver [Map]<Key, Value>
 * @param callback Function1<[Map.Entry]<Key, Value>, Unit>
 */

public inline fun <Key, Value> Map<Key, Value>.assertSingle(callback: (Map.Entry<Key, Value>) -> Unit) {
    contract {
        callsInPlace(callback, InvocationKind.AT_MOST_ONCE)
    }
    assertSize(expected = 1, message = "should have single item.")
    callback(entries.first())
}

/**
 * Asserts this map only contains 1 element with the given [expectedKey] and [expectedValue]
 * @param expectedKey [Key]
 * @param expectedValue [Value]
 * @param message String
 */
public inline fun <Key, reified Value> Map<Key, Value>.assertSingle(
    expectedKey: Key,
    expectedValue: Value,
    message: String = ""
) where Key : Comparable<Key>, Value : Comparable<Value> {
    assertSingle(expected = expectedKey to expectedValue, message = message)
}