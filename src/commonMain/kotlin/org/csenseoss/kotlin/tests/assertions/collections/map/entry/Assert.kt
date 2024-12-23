@file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package org.csenseoss.kotlin.tests.assertions.collections.map.entry

import org.csenseoss.kotlin.tests.assertions.comparable.*
import org.csenseoss.kotlin.tests.assertions.general.*

public inline fun <Key, Value> Map.Entry<Key, Value>?.assert(
    key: Key,
    value: Value
) where Key : Comparable<Key>, Value : Comparable<Value> {
    assertNotNull()
    this.key.assert(key)
    this.value.assert(value)
}

public inline fun <Key, Value> Map.Entry<Key, Value>?.assert(
    expected: Map.Entry<Key, Value>
): Unit where Key : Comparable<Key>, Value : Comparable<Value> = assert(
    key = expected.key,
    value = expected.value
)


public inline fun <Key, Value> Map.Entry<Key, Value>?.assert(
    expected: Pair<Key, Value>
): Unit where Key : Comparable<Key>, Value : Comparable<Value> = assert(
    key = expected.first,
    value = expected.second
)