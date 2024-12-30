@file:Suppress("NOTHING_TO_INLINE")

package org.csenseoss.kotlin.tests.assertions.collections.map.entry

import org.csenseoss.kotlin.tests.assertions.comparable.*
import org.csenseoss.kotlin.tests.assertions.general.*

public inline fun <Key, Value> Map.Entry<Key, Value>?.assert(
    key: Key,
    value: Value,
    message: String = ""
) where Key : Comparable<Key>, Value : Comparable<Value> {
    assertNotNull()
    this.key.assert(key, message)
    this.value.assert(value, message)
}

public inline fun <Key, Value> Map.Entry<Key, Value>?.assert(
    expected: Map.Entry<Key, Value>,
    message: String = ""
): Unit where Key : Comparable<Key>, Value : Comparable<Value> = assert(
    key = expected.key,
    value = expected.value,
    message = message
)


public inline fun <Key, Value> Map.Entry<Key, Value>?.assert(
    expected: Pair<Key, Value>,
    message: String
): Unit where Key : Comparable<Key>, Value : Comparable<Value> = assert(
    key = expected.first,
    value = expected.second,
    message = message
)