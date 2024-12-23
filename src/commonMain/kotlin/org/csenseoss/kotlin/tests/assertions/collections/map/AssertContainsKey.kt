package org.csenseoss.kotlin.tests.assertions.collections.map

import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*


/**
 * asserts that the given [key] is in this [Map]
 * @receiver [Map]<Key, Value>
 * @param key [Key] the key to test for
 */
public fun <Key, Value> Map<Key, Value>.assertContainsKey(
    key: Key,
    message: String = "Expected \"$key\" in map but was not found"
) {
    containsKey(key).assertTrue(message)
}