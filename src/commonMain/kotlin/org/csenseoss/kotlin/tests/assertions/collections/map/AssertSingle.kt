package org.csenseoss.kotlin.tests.assertions.collections.map

import org.csenseoss.kotlin.tests.assertions.collections.map.entry.*
import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.contracts.*
import kotlin.test.*


/**
 * Asserts this map only contains 1 element (the given [item])
 * @receiver [Map]<Key, Value>
 * @param item [Map.Entry]<Key, Value>
 * @param message String
 */
public fun <Key, Value> Map<Key, Value>.assertSingle(
    item: Map.Entry<Key, Value>,
    message: String = ""
) where Key : Comparable<Key>, Value : Comparable<Value> {
    assertSize(expectedSize = 1, message = "should have single item. $message")
    entries.first().assert(item)
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
) where Key : Comparable<Key>, Value : Comparable<Value> {
    assertSize(expectedSize = 1, message = "should have single item. $messageForSize")
    entries.first().assert(keyValue)
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
    assertSize(expectedSize = 1, message = "should have single item.")
    callback(entries.first())
}