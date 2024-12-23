package org.csenseoss.kotlin.tests.assertions.collections.map

import org.csenseoss.kotlin.tests.assertions.comparable.*
import org.csenseoss.kotlin.tests.assertions.general.*
import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*


/**
 * Asserts that this [Map] contains the given [Map.Entry] (by key and then by value)
 * @receiver [Map]<Key, Value>
 * @param entry [Map.Entry]<Key, Value> the entry to assert exists
 */
public inline fun <Key, reified Value> Map<Key, Value>.assertContains(
    entry: Map.Entry<Key, Value>,
    message: String = ""
) where Key : Comparable<Key>, Value : Comparable<Value> {
    val value: Value? = get(entry.key)
    value.assertNotNull("key \"${entry.key}\" not found in ($keys)")
    value.assert(expected = entry.value, message = message)
}

/**
 * Asserts that this [Map] contains the given [Map.Entry] (by key and then by value)
 * @receiver [Map]<Key, Value>
 * @param entry [Map.Entry]<Key, Value> the entry to assert exists
 */
public inline fun <Key, reified Value> Map<Key, Value>.assertContains(
    entry: Pair<Key, Value>,
    message: String = "Expected to find \"$entry\" but found none"
) where Key : Comparable<Key>, Value : Comparable<Value> {
    val value: Value? = get(entry.first)
    value.assertNotNull("key \"${entry.first}\" not found in ($keys)")
    value.assert(expected = entry.second, message = message)
}

/**
 * Asserts that this [Map] contains the given [Map.Entry] (by key and then by value)
 * @receiver [Map]<Key, Value>
 * @param entry [Map.Entry]<Key, Value> the entry to assert exists
 */
public inline fun <Key, reified Value> Map<Key, Value>.assertContains(
    predicate: (key: Key, value: Value) -> Boolean,
    message: String = "Expected to find a key/value based on predicate, but found none"
) where Key : Comparable<Key>, Value : Comparable<Value> {
    val didFind: Boolean = entries.any { it: Map.Entry<Key, Value> -> predicate(it.key, it.value) }
    didFind.assertTrue(message = message)
}