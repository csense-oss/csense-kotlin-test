package org.csenseoss.kotlin.tests.assertions.collections.map

import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*


/**
 * asserts that the given [key] is missing from this [Map]
 * @receiver [Map]<Key, Value>
 * @param key [Key] the key to test whenever is missing
 */
public fun <Key, Value> Map<Key, Value>.assertDoesNotContainsKey(
    key: Key,
    message: String = "Expected $key to be absent from this map, but is present"
) {
    containsKey(key).assertFalse(message)
}